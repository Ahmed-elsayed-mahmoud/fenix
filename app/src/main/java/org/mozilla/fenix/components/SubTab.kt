package org.mozilla.fenix.components

import com.google.gson.annotations.SerializedName
import java.net.URI

data class SubTabsResult(
        @SerializedName("subtabs") val subTabs: List<SubTab>,
        @SerializedName("suggested_augmentations") val suggestedAugmentations: List<Augmentation>
)

data class SubTab(
        @SerializedName("url") val url: String,
        @SerializedName("title") val title: String?,
        @SerializedName("rank") val rank: Int,
        @SerializedName("default") val isDefault: Boolean?,
        @SerializedName("isReaderMode") val isReaderMode: Boolean?,
        @SerializedName("ALL_isOriginalPageSerp") val isOriginalPageSerp: Boolean?,
)

data class Augmentation(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
)

fun subTabTitle(subTab: SubTab): String {
    if (subTab.title != null)  {
        return subTab.title
    }

    if (subTab.isReaderMode == true) {
        return "Readable"
    }
    val uri = URI(subTab.url)
    val domain: String = uri.host
    return if (domain.startsWith("www.")) domain.substring(4) else domain
}