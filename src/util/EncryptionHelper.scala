package util

import java.security.MessageDigest
import org.primefaces.util.Base64

object EncryptionHelper {//TODO check if object fonction doesnt do buttleneck
	def hashPassword(password: String, salt: String): String = {
    val ALGO_CHIFFREMENT = "SHA-256";
    val md = MessageDigest.getInstance(ALGO_CHIFFREMENT);
    return Base64.encodeToString(md.digest((salt + password).getBytes("UTF-8")), false);
  }
}