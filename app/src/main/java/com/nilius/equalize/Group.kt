package com.nilius.equalize

import android.os.Debug
import android.util.Log

class Group(firstUser:User,name:String) {

    private var members : MutableList<User> = mutableListOf(firstUser)
    private var payments : MutableList<Payment> = mutableListOf()
    private var name = name
    private var totalCash : Int = 0


    fun addGroupMember(member:User){
        this.members.add(member)
    }

    fun removeGroupMember(member: User){
        this.members.remove(member)
    }

    fun listGroupMembers() : List<String>{
        var names = mutableListOf<String>()
        for(u in this.members){
            names.add(u.getName())
        }
        return names
    }

    fun addPayment(payment:Payment){
        this.payments.add(payment)
    }

    fun getTotalCash() : Float{
        var amount:Float = 0.0f
        for(p in this.payments){
            amount += p.amount
        }
        return amount
    }

     fun printGroup(){
        for(u in this.members) {
            Log.d("TAG",u.getName())
        }
        Log.d("TAG",this.getTotalCash().toString())
    }


}