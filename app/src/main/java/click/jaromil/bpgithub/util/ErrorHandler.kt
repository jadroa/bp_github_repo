package click.jaromil.bpgithub.util


//TODO: This can be more sophisticated
class ErrorHandler {
    companion object {
        fun processError(throwable: Throwable): String {
            return throwable.message ?: "unknown error"
        }
    }
}