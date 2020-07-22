package au.com.flyingbits.jetpacktestkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    private var num: MutableLiveData<Int> = MutableLiveData(0)

    public fun getNum(): MutableLiveData<Int> {
        return this.num
    }

    public fun addNum(n: Int) {
        this.num.value = this.num.value!! + n
    }

}