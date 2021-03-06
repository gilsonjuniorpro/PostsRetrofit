package gov.pr.celepar.investigacao.pojo

import android.os.Parcel
import android.os.Parcelable


data class Post(
        val id: Long,
        val address: String,
        val image: String,
        val title: String,
        val description: String,
        val isSupported: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(address)
        parcel.writeString(image)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(isSupported)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post {
            return Post(parcel)
        }

        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }


}