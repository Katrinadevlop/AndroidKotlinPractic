package com.example.mynavigation.DataClass

import android.os.Parcel
import android.os.Parcelable

class DataClassUserParcelable(
    var name:String,
    var surname:String,
    var age:Int,
    var birthday:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(surname)
        dest.writeInt(age)
        dest.writeString(birthday)
    }

    companion object CREATOR : Parcelable.Creator<DataClassUserParcelable> {
        override fun createFromParcel(parcel: Parcel): DataClassUserParcelable {
            return DataClassUserParcelable(parcel)
        }

        override fun newArray(size: Int): Array<DataClassUserParcelable?> {
            return arrayOfNulls(size)
        }
    }
}