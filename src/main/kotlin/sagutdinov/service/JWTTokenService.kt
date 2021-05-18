package sagutdinov.service

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import sagutdinov.model.UserModel

class JWTTokenService {
    private val secret = "C7F14357-2F70-47FA-9D0B-A019AE57EE7C"
    private val algo = Algorithm.HMAC256(secret)

    val verifier: JWTVerifier = JWT.require(algo).build()

    fun generate(model: UserModel): String = JWT.create()
        .withClaim("id", model.id)
        .withClaim("password", model.password)
        .sign(algo)
}