package com.example.android_project

object Constants {






    const  val TOTAL_QUESTIONS: String= "total_question"
    const val CORRECT_ANSWERS: String="correct_answers"

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "Milyen állat ez?",
            R.drawable.majom,
            "Majom",
            "Gorilla",
            "Orangután",
            "Csimpánz",
            1)

        val question2 = Question(
            2,
            "Milyen állat ez?",
            R.drawable.feketeparduc,
            "Párduc",
            "Jaguár",
            "Macska",
            "Feketepárduc",
            4)

        val question3 = Question(
            3,
            "Milyen állat ez?",
            R.drawable.jaguar,
            "Párduc",
            "Fecske",
            "Jaguár",
            "Ló",
            3)

        val question4 = Question(
            4,
            "Milyen állat ez?",
            R.drawable.koala,
            "Koala",
            "Lajhár",
            "Medve",
            "Panda",
            1)

        val question5 = Question(
            5,
            "Milyen állat ez?",
            R.drawable.krokodil,
            "Aligátor",
            "Krokodil",
            "Giliszta",
            "Gólya",
            2)

        val question6 = Question(
            6,
            "Milyen állat ez?",
            R.drawable.lajhar,
            "Panda",
            "Koala",
            "Lajhár",
            "Gyík",
            3)

        val question7 = Question(
            7,
            "Milyen állat ez?",
            R.drawable.medve,
            "Jegesmedve",
            "Feketemedve",
            "Barnamedve",
            "Panda",
            3)

        val question8 = Question(
            8,
            "Milyen állat ez?",
            R.drawable.oroszlan,
            "Tigris",
            "Macska",
            "Párduc",
            "Oroszlán",
            4)


        val question9 = Question(
            9,
            "Milyen állat ez?",
            R.drawable.zebra,
            "Ló",
            "Antilop",
            "Zebra",
            "Viziló",
            3)

        val question10 = Question(
            10,
            "Milyen állat ez?",
            R.drawable.zsiraf,
            "Zebra",
            "Pelikán",
            "Denevér",
            "Zsiráf",
            4)

        val question11 = Question(
            11,
            "Melyik szervünk biztosítja a légzés során a gázcsere folyamatát?",
            R.drawable.tudo,
            "Tüdő",
            "Szív",
            "Vese",
            "Máj",
            1)

        val question12 = Question(
            12,
            "Melyik sejt felelős az immunrendszer működéséért?",
            R.drawable.sejt,
            "B-sejt",
            "T-sejt",
            "Vörösvérsejt",
            "Fehérvérsejt",
            4)

        val question13 = Question(
            13,
            "Melyik szervünk felelős az emésztés során a tápanyagok felszívódásáért?",
            R.drawable.belrendszer,
            "Gyomor",
            "Máj",
            "Vese",
            "Bélrendszer",
            4)

        val question14 = Question(
            14,
            "Melyik állítás igaz az evolúciós elméletre?",
            R.drawable.evolucio,
            "Az evolúció csak elmélet, nincs bizonyíték rá",
            "Az evolúció folyamatos és lassú folyamat",
            "Az evolúció csak az emberi fajjal történik",
            "Az evolúció véletlenszerű folyamat, nincs iránya",
            2)

        val question15 = Question(
            15,
            "Milyen típusú sejtből áll az emberi szervezet legnagyobb szerve, a bőr?",
            R.drawable.emberibor,
            "Vérsejtből",
            " Idegsejtből",
            "Laphámsejtből",
            "Porcsejtből",
            3)

        val question16 = Question(
            16,
            "Melyik szervünk választja ki a vizeletet a vérünk tisztítása során?",
            R.drawable.vese,
            "Vese",
            "Szív",
            "Tüdő",
            "Gyomor",
            1)

        val question17 = Question(
            17,
            "Melyik szervünk felelős a szénhidrátok emésztéséért?",
            R.drawable.hasnyalmirigy,
            "Gyomor",
            "Máj",
            "Hasnyálmirigy",
            "Vakbél",
            3)

        val question18 = Question(
            18,
            "Mi volt az a 3,2 millió éves csontváz maradvány neve, amely egy korai emberfajhoz tartozó nőstény egyedről van szó?",
            R.drawable.lucy,
            "Ádám",
            "Lucy",
            "Éva",
            "Lilith",
            2)

        val question19 = Question(
            19,
            "Mi az a nünüke?",
            R.drawable.nunuke,
            "Egy édesipari termék",
            " Egy növényfajta",
            "Egy rovar",
            "Egy fajta édesség",
            3)

        val question20 = Question(
            20,
            "Miért érdekesek a hidrák kutatás szempontjából?",
            R.drawable.hidra,
            "Ragadozó életmódjuk miatt",
            "Jó álcázó képességük van",
            "Biológiailag halhatatlanok",
            "Szaporodásuk miatt",
            3)



        val questionArray = arrayOf(question1, question2, question3, question4,question5,question6,question7,question8,
            question9,question10,question11,question12,question13,question14,question15,question16,question17,question18,
            question19,question20)
        val randomQuestions = questionArray.toList().shuffled().take(10)

        questionList.add(randomQuestions[0])
        questionList.add(randomQuestions[1])
        questionList.add(randomQuestions[2])
        questionList.add(randomQuestions[3])
        questionList.add(randomQuestions[4])
        questionList.add(randomQuestions[5])
        questionList.add(randomQuestions[6])
        questionList.add(randomQuestions[7])
        questionList.add(randomQuestions[8])
        questionList.add(randomQuestions[9])

        return questionList

    }
}