package workflow.response

import model.base.BaseWebserviceResponse
import model.base.WSCode
import org.springframework.http.HttpStatus

class DeleteItemWebserviceResponse(status: HttpStatus,
                                   wsCode: WSCode,
                                   wsCodeValue: String,
                                   reason: String) : BaseWebserviceResponse(status, wsCode, wsCodeValue, reason)