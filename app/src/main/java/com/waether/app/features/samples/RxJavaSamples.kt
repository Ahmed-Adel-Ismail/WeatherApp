package com.waether.app.features.samples

import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

fun main() {
    flatMappingUseCase(MutableLiveData())
        .subscribe({println(it)})
}

data class ResponseOne(val value: Int)
data class ResponseTwo(val value: String)
data class FinalResult(val int: Int, val string: String)


fun flatMappingUseCase(progressLiveData : MutableLiveData<Boolean>) : Observable<String> {

    return retrofitApiCallZero()
        .takeUnless { progressLiveData.value ?: false }
        ?.also { progressLiveData.postValue(true) }
        ?.subscribeOn(Schedulers.computation())
        ?.observeOn(Schedulers.io())
        ?.flatMap { integer -> retrofitApiCallOne(integer) }
        ?.map { responseOne -> responseOne.value }
        ?.flatMap { integer -> retrofitApiCallTwo(integer) }
        ?.map { responseTwo -> responseTwo.value }
        ?.observeOn(AndroidSchedulers.mainThread())
        ?.doFinally { progressLiveData.postValue(false) }
        ?: Observable.empty()

}


fun ziping() {

    val retrofitApiOne = Observable.fromCallable<ResponseOne> {
        ResponseOne(1)
    }

    val retrofitApiTwo = Observable.fromCallable<ResponseTwo> {
        ResponseTwo("2")
    }



    Observable.zip(
        retrofitApiOne,
        retrofitApiTwo,
        BiFunction<ResponseOne, ResponseTwo, FinalResult> { responseOne, responseTwo ->
            FinalResult(responseOne.value, responseTwo.value)
        }
    ).subscribe { println(it) }


}


fun retrofitApiCallZero(): Observable<Int> {
    return Observable.just(0)
}

fun retrofitApiCallOne(parameter: Int): Observable<ResponseOne> {
    return Observable.just(ResponseOne(parameter))
}

fun retrofitApiCallTwo(parameter: Int): Observable<ResponseTwo> {
    return Observable.just(ResponseTwo("value is $parameter"))
}


