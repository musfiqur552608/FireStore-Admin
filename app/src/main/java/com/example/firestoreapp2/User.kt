package com.example.firestoreapp2

class User {
    var name:String?=null
    var pass:String?=null
    var id:String?=null
    constructor(){

    }

    constructor(name: String?, pass: String?, id: String?) {
        this.name = name
        this.pass = pass
        this.id = id
    }
}