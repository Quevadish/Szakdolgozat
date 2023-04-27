package com.example.android_project

object Constants {

    const  val TOTAL_QUESTIONS: String= "total_question"
    const val CORRECT_ANSWERS: String="correct_answers"

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Milyen állat ez?",
            R.drawable.majom,
            "Majom",
            "Gorilla",
            "Orangután",
            "Csimpánz",
            1)

        questionList.add(que1)

        val que2 = Question(
            2,
            "Milyen állat ez?",
            R.drawable.feketeparduc,
            "Párduc",
            "Jaguár",
            "Macska",
            "Feketepárduc",
            4)

        questionList.add(que2)

        val que3 = Question(
            3,
            "Milyen állat ez?",
            R.drawable.jaguar,
            "Párduc",
            "Fecske",
            "Jaguár",
            "Ló",
            3)

        questionList.add(que3)

        val que4 = Question(
            4,
            "Milyen állat ez?",
            R.drawable.koala,
            "Koala",
            "Lajhár",
            "Medve",
            "Panda",
            1)

        questionList.add(que4)

        val que5 = Question(
            5,
            "Milyen állat ez?",
            R.drawable.krokodil,
            "Aligátor",
            "Krokodil",
            "Giliszta",
            "Gólya",
            2)

        questionList.add(que5)

        val que6 = Question(
            6,
            "Milyen állat ez?",
            R.drawable.lajhar,
            "Panda",
            "Koala",
            "Lajhár",
            "Gyík",
            3)

        questionList.add(que6)

        val que7 = Question(
            7,
            "Milyen állat ez?",
            R.drawable.medve,
            "Jegesmedve",
            "Feketemedve",
            "Barnamedve",
            "Panda",
            3)

        questionList.add(que7)

        val que8 = Question(
            8,
            "Milyen állat ez?",
            R.drawable.oroszlan,
            "Tigris",
            "Macska",
            "Párduc",
            "Oroszlán",
            4)

        questionList.add(que8)

        val que9 = Question(
            9,
            "Milyen állat ez?",
            R.drawable.zebra,
            "Ló",
            "Antilop",
            "Zebra",
            "Viziló",
            3)

        questionList.add(que9)

        val que10 = Question(
            10,
            "Milyen állat ez?",
            R.drawable.zsiraf,
            "Zebra",
            "Pelikán",
            "Denevér",
            "Zsiráf",
            4)

        questionList.add(que10)

        return questionList

    }
}