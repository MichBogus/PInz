package controller.base

import workflow.model.base.BaseWebserviceResponse
import org.springframework.http.HttpStatus

abstract class BaseController {

    fun generateResponseEntity(response: BaseWebserviceResponse, status: HttpStatus): WSResponseEntity {
        return WSResponseEntity(response, status)
    }
}