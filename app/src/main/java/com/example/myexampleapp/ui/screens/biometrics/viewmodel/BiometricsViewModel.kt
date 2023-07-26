package com.example.myexampleapp.ui.screens.biometrics.viewmodel

import android.content.Context
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyPermanentlyInvalidatedException
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.security.InvalidKeyException
import java.security.KeyStore
import java.util.concurrent.Executor
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.inject.Inject

@HiltViewModel
class BiometricsViewModel @Inject constructor(
    @ApplicationContext val cnx: Context
) : ViewModel() {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    fun configBiometric(fragment: FragmentActivity){
        executor = ContextCompat.getMainExecutor(cnx)
        biometricPrompt = BiometricPrompt(fragment, executor, object : BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                when(errorCode){
                    BiometricPrompt.ERROR_LOCKOUT->{
                        //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_many_attempts))
                    }
                    BiometricPrompt.ERROR_LOCKOUT_PERMANENT->{
                        //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_many_attempts))
                    }
                    BiometricPrompt.ERROR_NO_BIOMETRICS->{
                        //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_none_enrolled))
                    }
                    BiometricPrompt.ERROR_NO_DEVICE_CREDENTIAL->{
                        //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_none_enrolled))
                    }
                    BiometricPrompt.ERROR_TIMEOUT->{}
                    BiometricPrompt.ERROR_USER_CANCELED->{}
                    BiometricPrompt.ERROR_CANCELED->{}
                    else->{}
                }
            }
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                //val user = UniqueID.getInstance(requireContext()).getUser()
                //val deviceId = UniqueID.getInstance(requireContext()).getAppID()
                //presenter?.sendSuccesEmail(user, deviceId, true)
            }
        })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Authentication")
            .setDescription("Coloca el tu dedo en el lector de huellas")
            .setNegativeButtonText("Cancelar")
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
            .build()

        /**
        override fun onSuccessCredentials() {
            val biometricManager = androidx.biometric.BiometricManager.from(requireContext())
            this.validateBiometricAction(biometricManager) {
                this.validateBiometricChange()
                biometricPrompt.authenticate(promptInfo)
            }
        }
        */
    }

    fun checkBiometrics(fragment: Fragment){
        lateinit var executor: Executor
        lateinit var biometricPrompt: BiometricPrompt
        lateinit var promptInfo: BiometricPrompt.PromptInfo

        executor = ContextCompat.getMainExecutor(cnx)
        biometricPrompt = BiometricPrompt(fragment, executor, object : BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                when(errorCode){
                    BiometricPrompt.ERROR_LOCKOUT, BiometricPrompt.ERROR_LOCKOUT_PERMANENT ->{
                        //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_many_attempts))
                    }
                    BiometricPrompt.ERROR_NO_BIOMETRICS, BiometricPrompt.ERROR_NO_DEVICE_CREDENTIAL->{
                        //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_none_enrolled))
                    }
                    else->{}
                }
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                //val appID = UniqueID.getInstance(requireActivity()).getAppID()
                //val strUser = UniqueID.getInstance(requireActivity()).getUser()
                //loginPresenter?.loginWithBiometris(strUser, appID, requireContext())
            }
        })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("string.str_biometric_fingerprint")
            .setDescription("R.string.str_biometric_fingerprint_msj)")
            .setNegativeButtonText("R.string.str_negative_button_biometric")
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
            .build()

        /**
        this.btnLoginBiometricEnable.setOnClickListener {
            this.validateBiometricAction(biometricManager) {
                this.validateBiometricChange()
                if (prefs.getBoolean(RELOAD_BIOMETIC, false)) {
                    biometricPrompt.authenticate(promptInfo)
                }
                else {
                    //createAlert(updateLanguageByItemFragment(R.string.str_biometric_changue))
                }
            }
        }
        */
    }
    fun validateBiometricChange() {
        val cipher = getCipher()
        val secretKey = getSecretKey()
        if (secretKey == null) {
            generateSecretKey(
                KeyGenParameterSpec.Builder("SECRETKEY_BIOMETRICS", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                    .setUserAuthenticationRequired(true)
                    .setInvalidatedByBiometricEnrollment(true)
                    .build()
            )
        }
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        }
        catch (e: KeyPermanentlyInvalidatedException) {
            //val prefs = PreferenceManager.getDefaultSharedPreferences(cnx)
            //prefs.edit().putBoolean("RELOAD_BIOMETIC", false).apply()
            generateSecretKey(
                KeyGenParameterSpec.Builder("SECRETKEY_BIOMETRICS", KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                    .setUserAuthenticationRequired(true)
                    .build()
            )
            //createAlert(updateLanguageByItemFragment(R.string.str_biometric_changue))
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        }
    }

    fun validateBiometricAction(biometricManager: BiometricManager, success: () -> Unit) {
        when(biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)){
            BiometricManager.BIOMETRIC_SUCCESS-> {
                success()
            }
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE->{
                //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_hw_unavailable))
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED->{
                //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_none_enrolled))
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE->{
                //createAlert(updateLanguageByItemFragment(R.string.str_alert_biometric_error_no_hardware))
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun generateSecretKey(keyGenParameterSpec: KeyGenParameterSpec) {
        val keyGenerator = KeyGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
        keyGenerator.init(keyGenParameterSpec)
        keyGenerator.generateKey()
    }

    fun getSecretKey(): SecretKey? {
        val keyStore = KeyStore.getInstance("AndroidKeyStore")
        keyStore.load(null)
        return keyStore.getKey("SECRETKEY_BIOMETRICS", null) as? SecretKey?
    }

    fun getCipher(): Cipher {
        return Cipher.getInstance(
            KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7)
    }
}
