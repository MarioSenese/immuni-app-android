package org.immuni.android.api.model

import org.immuni.android.models.survey.raw.RawSurvey
import com.bendingspoons.oracle.api.model.OracleSettings
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.immuni.android.models.survey.Survey

@JsonClass(generateAdapter = true)
class ImmuniSettings(
    @field:Json(name = "development_devices") val developmentDevices: List<String> = listOf(),
    @field:Json(name = "reminder_notification_title") val reminderNotificationTitle: String = "Compila il diario",
    @field:Json(name = "reminder_notification_message") val reminderNotificationMessage: String = "Ricordati di compilare il diario clinico di oggi",
    @field:Json(name = "privacy_url") val privacyPolicyUrl: String? = null,
    @field:Json(name = "tos_url") val termsOfServiceUrl: String? = null,
    @field:Json(name = "faq_url") val faqUrl: String? = null,
    @field:Json(name = "survey_json") val rawSurvey: RawSurvey? = null,
    @field:Json(name = "disable_survey_back") val disableSurveyBack: Boolean = false,
    @field:Json(name = "user_data_retention_days") val userDataRetentionDays: Int? = null,
    @field:Json(name = "pico_ping_periodicity") val picoPingPeriodicity: Int? = null,
    @field:Json(name = "pico_contacts_upload_periodicity") val picoContactsUploadPeriodicity: Int? = null,
    @field:Json(name = "app_update_url") val appUpdateUrl: String? = null,
    @field:Json(name = "support_email") val supportEmail: String? = null,
    @field:Json(name = "delete_data_email") val deleteDataEmail: String? = null,
    @field:Json(name = "recover_data_email") val recoverDataEmail: String? = null,
    @field:Json(name = "ble_disable_all") val bleDisableAll: Boolean = false,
    @field:Json(name = "ble_timeout_seconds") val bleTimeoutSeconds: Int = 180
) : OracleSettings() {
    @Transient private var _survey: Survey? = null
    val survey: Survey?
        get() {
            if (_survey == null) _survey = rawSurvey?.survey()
            return _survey
        }
}