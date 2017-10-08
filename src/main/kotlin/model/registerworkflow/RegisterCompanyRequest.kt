package model.registerworkflow

import com.fasterxml.jackson.annotation.JsonProperty
import model.base.BaseRequest
import model.base.BaseWebserviceResponse
import model.base.WSCode
import model.company.CompanyAddress
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import utils.WSString

class RegisterCompanyRequest(@JsonProperty("name") @NotNull val name: String,
                             @JsonProperty("address") @NotNull val address: CompanyAddress,
                             @JsonProperty("NIP") @NotNull val companyNip: String) : BaseRequest() {

    override fun checkIfRequestIsValid(): BaseWebserviceResponse {
        if (name.isNullOrEmpty()) {
            return BaseWebserviceResponse(HttpStatus.BAD_REQUEST, WSCode.ERROR_WRONG_FIELD, WSString.REGISTER_COMPANY_NAME_INVALID.tag)
        }

        if (address == null || address.isValid().not()) {
            return BaseWebserviceResponse(HttpStatus.BAD_REQUEST, WSCode.ERROR_WRONG_FIELD, WSString.REGISTER_COMPANY_ADDRESS_INVALID.tag)
        }

        if (companyNip.isNullOrEmpty()) {
            return BaseWebserviceResponse(HttpStatus.BAD_REQUEST, WSCode.ERROR_WRONG_FIELD, WSString.REGISTER_COMPANY_NIP_INVALID.tag)
        }

        return super.checkIfRequestIsValid()
    }
}