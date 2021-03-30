package com.makaryostudio.mukbang.model.question

object QuestionData {
    private val listCubeQuestion = arrayListOf(
        "Rama akan membuat 3 buah kerangka balok yang berukuran 6 cm x 6 cm x 3 cm terbuat dari kawat. Jika kawat yang tersedia 2 m, panjang sisa kawat adalah …",
        "Sebuah kubus memiliki volume 343 cm³. Jika panjang rusuk kubus tersebut diperbesar menjadi 4 kali panjang rusuk semula. Maka volume kubus yang baru adalah … cm³",
        "Sebuah balok mempunyai luas permukaan 376 cm². Jika panjang balok 10 cm dan lebar balok 6 cm. Tinggi dari balok tersebut adalah … cm",
        "Volume sebuah kubus sama dengan volume balok yaitu 1.000 cm³. Diketahui panjang balok dua kali panjang kubus dan tinggi balok setengah kali lebar balok. Luas permukaan balok adalah … cm²",
        "Suatu balok memiliki luas permukaan 198 cm². Jika lebar dan tinggi balok masing-masing 6 cm dan 3 cm, tentukan panjang balok tersebut!",
        "Dua buah kubus masing-masing panjang rusuknya 6 cm dan 10 cm. Hitunglah perbandingan luas permukaan dua kubus tersebut adalah …",
        "Made akan membuat 15 buah kerangka balok yang masing-masing berukuran 30 cm x 20 cm x 15 cm. Jumlah panjang kawat yang diperlukan untuk membuat balok tersebut adalah … meter",
        "Made akan membuat 15 buah kerangka balok yang masing-masing berukuran 30 cm x 20 cm x 15 cm. Bahan yang akan digunakan terbuat dari kawat yang harganya Rp 1.500/m. Biaya yang diperlukan untuk membeli bahan/kawat adalah …",
        "Panjang kawat yang diperlukan untuk membuat kotak kapur tulis berukuran (6 x 4 x 5) cm adalah …",
        "Sukma memiliki kawat sepanjang 156 cm. Ia ingin menggunakan kawat tersebut untuk membuat kerangka kubus. Panjang rusuk kubus agar kawat tidak bersisa adalah … cm"
    )

    private val listCubeOptionA = arrayListOf(
        "20 cm",
        "64",
        "6",
        "700",
        "6",
        "3 : 5",
        "24",
        "Rp38.500,00",
        "40 cm",
        "6"
    )

    private val listCubeOptionB = arrayListOf(
        "24 cm",
        "343",
        "8",
        "900",
        "7",
        "3 : 10",
        "39",
        "Rp48.500,00",
        "60 cm",
        "10"
    )

    private val listCubeOptionC = arrayListOf(
        "30 cm",
        "3.646",
        "10",
        "1.100",
        "8",
        "9 : 15",
        "46",
        "Rp58.500,00",
        "80 cm",
        "13"
    )

    private val listCubeOptionD = arrayListOf(
        "32 cm",
        "21.952",
        "12",
        "1.300",
        "9",
        "9 : 25",
        "49",
        "Rp 68.500,00",
        "100 cm",
        "18"
    )

    private val listCubeKey = arrayListOf(
        "a",
        "d",
        "c",
        "a",
        "d",
        "d",
        "b",
        "c",
        "b",
        "c"
    )

    private val listCubeExplanation = arrayListOf(
        "Kerangka balok disusun oleh 4 rusuk panjang, 4 rusuk lebar, dan 4 rusuk tinggi. Sehingga, panjang kawat untuk membuat 1 (satu) kerangka balok adalah sebagai berikut\n" +
                "= 4p + 4l + 4t\n" +
                "= 4(6) + 4(6) + 4(3)\n" +
                "=  60 cm\n" +
                "Panjang kawat untuk membuat 3 (tiga) kerangka balok adalah\n" +
                "= 60 x 3\n" +
                "= 180 cm\n" +
                "Mencari sisa panjang kawat\n" +
                " = 2m – 180 cm\n" +
                "= 200 cm – 180 cm\n" +
                "= 20 cm\n" +
                "Kita harus mencari panjang rusuk awal (s0), yakni:\n" +
                "V0 = s³\n" +
                "343 cm³ = s³\n" +
                "(7 cm)³ = s³\n" +
                "s0  = 7 cm\n" +
                "Sekarang kita hitung panjang jika rusuk tersebut diperbesar 4 kali dari panjang semula, maka\n" +
                "s1 = 4s0\n" +
                "s1 = 4.7 cm\n" +
                "s1 = 28 cm\n" +
                "Sekarang kita hitung volume kubus setelah rusuknya diperbesar 4 kali yakni:\n" +
                "V1 = s³\n" +
                "V1 = (28 cm)³\n" +
                "V1 = 21.952 cm³.\n" +
                "Jadi volume kubus setelah diperbesar 4 kali adalah 21.952 cm³",
        "Untuk mencari tinggi balok tersebut gunakan rumus luas permukaan balok yaitu:\n" +
                "L  = 2(p.l + p.t + l.t)\n" +
                "376 cm² = 2(10 cm.6 cm + 10 cm.t + 6 cm.t)\n" +
                "376 cm² = 2 (60 cm² +10 cm.t +6 cm.t)\n" +
                "376 cm² = 2(60 cm² + 16 cm.t)\n" +
                "376 cm² = 120 cm² + 32 cm.t\n" +
                "376 cm² – 120 cm² = 32 cm.t\n" +
                "256 cm² = 32 cm.t\n" +
                "t = 256 cm²/32 cm\n" +
                "t = 8 cm\n" +
                "\n" +
                "Jadi tinggi balok tersebut adalah 8 cm.",
        "Untuk mencari tinggi balok tersebut gunakan rumus luas permukaan balok yaitu:\n" +
                "L = 2(p.l + p.t + l.t)\n" +
                "376 cm² = 2(10 cm.6 cm + 10 cm.t + 6 cm.t)\n" +
                "376 cm² = 2 (60 cm² +10 cm.t +6 cm.t)\n" +
                "376 cm² = 2(60 cm² + 16 cm.t)\n" +
                "376 cm² = 120 cm² + 32 cm.t\n" +
                "376 cm² – 120 cm² = 32 cm.t\n" +
                "256 cm² = 32 cm.t\n" +
                "t = 256 cm²/32 cm\n" +
                "t = 8 cm\n" +
                "\n" +
                "Jadi tinggi balok tersebut adalah 8 cm.",
        "Untuk menjawab soal ini anda harus paham terlebih dahulu konsep volume kubus dan  volume balok. Karena volume balok sama dengan volume kubus maka Anda harus mencari panjang rusuk dari kubus tersebut yaitu\n" +
                "V = s³\n" +
                "1000 cm³ = s³\n" +
                "(10 cm)³ = s³\n" +
                "s = 10 cm\n" +
                "\n" +
                "Diketahui bahwa panjang balok sama dengan 2 kali panjang kubus, yaitu\n" +
                "p = 2s\n" +
                "p = 2.10 cm\n" +
                "p = 20 cm\n" +
                "Dan juga diketahui bahwa panjang balok sama dengan setengah tinggi dari balok tersebut, maka\n" +
                "t = ½ l atau l = 2.t\n" +
                "Kita sekarang akan mencari tinggi (t) pada balok dengan menggunakan konsep volume balok, yaitu\n" +
                "V = p.l.t\n" +
                "1000 cm³ = 20 cm.2t.t\n" +
                "1000 cm³ = 40 cm.t2\n" +
                "t = √(1000 cm3/40 cm)\n" +
                "t = √25 cm2\n" +
                "t = 5 cm\n" +
                "maka lebar balok yakni\n" +
                "l = 2t\n" +
                "l = 2.5 cm\n" +
                "l = 10 cm\n" +
                "Sekarang kita akan mencari luas permukaan balok dengan menggunakan rumus:\n" +
                "L = 2(p.l + p.t + l.t)\n" +
                "L = 2(20 cm.10 cm + 20 cm.5 cm + 10 cm.5 cm)\n" +
                "L = 2 (200 cm² +100 cm² +50 cm²)\n" +
                "L = 2(350 cm²)\n" +
                "L = 700 cm²\n" +
                "\n" +
                "Jadi luas permukaan balok tersebut adalah 700 cm²",
        "Untuk mencari panjang balok tersebut gunakan rumus luas permukaan balok yaitu:\n" +
                "L = 2(p.l + p.t + l.t)\n" +
                "198 cm² = 2(p.6 cm + p.3 cm + 6 cm.3 cm)\n" +
                "198 cm² = 2(6p cm + 3p cm + 18 cm²)\n" +
                "198 cm² = 2(9p cm + 18 cm²)\n" +
                "198 cm² = 18p cm + 36 cm²\n" +
                "198 cm² - 36 cm² = 18p cm\n" +
                "162 cm² = 18p cm\n" +
                "p = 162 cm2/18 cm\n" +
                "p = 9 cm\n" +
                "\n" +
                "Jadi, panjang balok tersebut adalah 9 cm\n",
        "L1 = 6s² = 6(6 cm)² = 216 cm²\n" +
                "L2 = 6s² = 6(10 cm)² = 600 cm²\n" +
                "\n" +
                "L1 : L2 = 216 : 600 = 9 : 25\n" +
                "\n" +
                "Jadi perbandingan luas permukaan kubus yang panjang rusuknya 6 cm dan 10 cm adalah 9 : 25",
        "Dari soal itu diketahui panjang = 30 cm, lebar 20 cm dan tinggi = 15 cm. Terlebih dahulu hitung berapa panjang kawat yang diperlukan untuk membuat satu buah kerangka balok, yaitu:\n" +
                "r = 4(p + l + t)\n" +
                "r = 4(30 cm + 20 cm + 15 cm)\n" +
                "r = 4(65 cm)\n" +
                "r = 260 cm\n" +
                "\n" +
                "Kita ketahui bahwa jumlah balok yang akan dibuat sebanyak 15 buah, maka panjang kawat yang diperlukan adalah:\n" +
                "r = 15. 260 cm\n" +
                "r = 3900 cm\n" +
                "r = 39 m\n",
        "Dari soal itu diketahui panjang = 30 cm, lebar 20 cm dan tinggi = 15 cm. Terlebih dahulu hitung berapa panjang kawat yang diperlukan untuk membuat satu buah kerangka balok, yaitu:\n" +
                "r = 4(p + l + t)\n" +
                "r = 4(30 cm + 20 cm + 15 cm)\n" +
                "r = 4(65 cm)\n" +
                "r = 260 cm\n" +
                "\n" +
                "Kita ketahui bahwa jumlah balok yang akan dibuat sebanyak 15 buah, maka panjang kawat yang diperlukan adalah:\n" +
                "r = 15. 260 cm\n" +
                "r = 3900 cm\n" +
                "r = 39 m\n" +
                "\n" +
                "Sekarang kita akan mencari berapa harga yang dibutuhkan untuk membuat kerangka balok kawat tersebut jika harga kawat = Rp 1.500/m, maka\n" +
                "Harga = harga kawat x panjang kawat\n" +
                "Harga = Rp 1.500/m x 39 m\n" +
                "Harga = Rp 58.500,00\n" +
                "\n" +
                "Jadi panjang kawat yang diperlukan untuk membuat 15 buah model kerangka balok dengan ukuran (30 cm x 20 cm x 15 cm) adalah 39 m dan biaya yang diperlukan adalah Rp 58.500,00",
        "Untuk membuat model kerangka balok dengan ukuran (6 x 4 x 5) cm dapat digunakan rumus:\n" +
                " r = 4(p + l + t)\n" +
                "r = 4(6 cm + 4 cm + 5 cm)\n" +
                "r = 4(15 cm)\n" +
                "r = 60 cm",
        "Diketahui:\n" +
                "r = 156 cm\n" +
                "\n" +
                "Ditanyakan:\n" +
                "s = ?\n" +
                "\n" +
                "Jawab:\n" +
                "r = 12s\n" +
                "s = r/12\n" +
                "s = 156 cm/12\n" +
                "s = 13 cm"
    )

    private val listPrismQuestion = arrayListOf(
        "Sebuah prisma tegak memiliki volume 432 cm³. Alas prisma tersebut berbentuk  segitiga siku-siku yang panjang sisi siku-sikunya 6 cm dan 8 cm. Tinggi prisma tersebut adalah…",
        "Dari gambar prisma segiempat tersebut, volume prisma ABCD.EFGH adalah … cm³",
        "Sebuah tenda memiliki ukuran seperti pada gambar di atas, volume tenda tersebut adalah … ",
        "Jika panjang rusuk prisma segi enam beraturan 6 cm dan tingginya 10√3 cm, maka luas permukaan prisma segi enam beraturan tersebut adalah …",
        "Sebuah prisma alasnya berbentuk segitiga siku-siku dengan sisi miring 26 cm dan salah satu sisi siku-sikunya 10 cm. Jika luas permukaan prisma 960 cm²,maka tinggi prisma tersebut adalah …",
    )

    private val listPrismOptionA = arrayListOf(
        "10 cm",
        "798",
        "2,5 m³",
        "468√3 cm²",
        "6 cm"
    )

    private val listPrismOptionB = arrayListOf(
        "18 cm",
        "898",
        "7,5 m³",
        "568√3 cm²",
        "8 cm"
    )

    private val listPrismOptionC = arrayListOf(
        "32 cm",
        "1200",
        "7,5 m³",
        "668√3 cm²",
        "10 cm"
    )

    private val listPrismOptionD = arrayListOf(
        "40 cm",
        "1366",
        "10 m³",
        "868√3 cm²",
        "12 cm"
    )

    private val listPrismKey = arrayListOf(
        "b",
        "a",
        "c",
        "a",
        "d"
    )

    private val listPrismExplanation = arrayListOf(
        "Hitung luas segitiga terlebih dahulu, yakni:\n" +
                "L∆ = ½ x 6 cm x 8 cm\n" +
                "L∆ = 24 cm²\n" +
                "\n" +
                "Hitung volume prisma dengan rumus, yakni:\n" +
                "V = L∆ x t\n" +
                "432 cm³ = 24 cm² x t\n" +
                "t = 432 cm³/24 cm²\n" +
                "t = 18 cm\n",
        "Luas alas prisma (luas ABCD) merupakan luas trapesium maka:\n" +
                "L. ABCD = ½ (CD + AB) x AD\n" +
                "L. ABCD = ½ (7 cm + 12 cm) x 6 cm\n" +
                "L. ABCD = 57 cm²\n" +
                "\n" +
                "Volume prisma ABCD.EFGH maka:\n" +
                "V = L. ABCD x AE\n" +
                "V = 57 cm² x 14 cm\n" +
                "V = 798 cm³\n",
        "Luas alas tenda merupakan luas segitiga maka:\n" +
                "L. alas = ½ x 2 m x 2,5 m\n" +
                "L. alas = 2,5 m²\n" +
                "\n" +
                "Volume tenda yaitu:\n" +
                "V = L. alas x tinggi\n" +
                "V = 2,5 m² x 3 m\n" +
                "V = 7,5 m³\n",
        "L = 3r(r√3+2t)\n" +
                "L = 3 . (6 cm)(( 6 cm)√3+2 . 10√3)\n" +
                "L = (18 cm)(6√3 cm + 20√3 cm)\n" +
                "L = (18 cm)(26√3 cm)\n" +
                "L = 468√3 cm²\n",
        "Cari panjang siku-siku yang kedua dengan teorema Pythagoras, yakni:\n" +
                "s = √(262 – 102)\n" +
                "s = √(676 – 100)\n" +
                "s = √576\n" +
                "s = 24 cm\n" +
                "L∆ = ½ x 10 cm x 24 cm\n" +
                "L∆ = 120 cm²\n" +
                "\n" +
                "K∆ = 10 cm + 24 cm + 26 cm\n" +
                "K∆ = 60 cm\n" +
                "\n" +
                "L = 2 x L∆ + K∆ . t\n" +
                "960 cm² = 2 x 120 cm² + 60 cm . t\n" +
                "960 cm² – 240 cm² = 60 cm . t\n" +
                "720 cm² = 60 cm . t\n" +
                "t = 12 cm\n"
    )

    private val listPyramidQuestion = arrayListOf(
        "Diketahui limas persegi dengan keliling alas 96 cm dan tinggi 9 cm. Volume limas tersebut adalah …",
        "Limas segiempat beraturan dengan panjang rusuk alasnya 14 cm dan tinggi sisi tegaknya 25 cm. Maka tinggi limas tersebut adalah …",
        "Alas sebuah limas segi empat beraturan berbentuk persegi. Jika tinggi segitiga 17 cm dan tinggi limas 15 cm, maka luas permukaan limas tersebut adalah …",
        "Perhatikan gambar limas segi empat beraturan di atas!\nJika panjang KL = 8 cm dan panjang KT = 12√2 cm. Panjang KO adalah …",
        "Perhatikan gambar limas segi empat beraturan di atas!\nJika panjang AB = 12 cm dan panjang BT = 10 cm. Tinggi limas atau panjang ET adalah …"
    )

    private val listPyramidOptionA = arrayListOf(
        "2.880 cm³",
        "12 cm",
        "800 cm²",
        "10√2 cm",
        "2√7 cm"
    )

    private val listPyramidOptionB = arrayListOf(
        "1.728 cm³",
        "18 cm",
        "900 cm²",
        "8√2 cm",
        "4√7 cm"
    )

    private val listPyramidOptionC = arrayListOf(
        "864 cm³",
        "24 cm",
        "1000 cm²",
        "6√2 cm",
        "6√7 cm"
    )

    private val listPyramidOptionD = arrayListOf(
        "288 cm³",
        "26 cm",
        "1200 cm²",
        "4√2 cm",
        "8√7 cm"
    )

    private val listPyramidKey = arrayListOf(
        "b",
        "c",
        "a",
        "d",
        "a"
    )

    private val listPyramidExplanation = arrayListOf(
        "Mencari sisi persegi:\n" +
                "K     = 96\n" +
                "4 x s = 96\n" +
                "s       = 96 : 4 = 24 cm\n" +
                "Diberikan sebuah limas beserta dengan ukurannya seperti berikut.\n" +
                "V.limas \t= 1/3 x l.alas x t\n" +
                "\t\t= 1/3 x 24 x 24 x 9\n" +
                "\t\t= 1.728 cm³\n",
        "Untuk mencari tinggi limas gunakan teorema Pythagoras, yakni:\n" +
                "ET= √(FT2 - EF2)\n" +
                "Dalam hal ini EF = ½ AB = 7 cm, maka:\n" +
                "ET = √(252 - 72)\n" +
                "ET = √(625 - 49)\n" +
                "ET = √576\n" +
                "ET = 24 cm\n" +
                "Jadi tinggi limas adalah 24 cm\n",
        "Untuk mencari luas permukaan limas yang pertama anda cari adalah panjang rusuk segiempat. Dalam hal ini AB = 2 x EF. EF dapat dicari dengan teorema Pythagoras.\n" +
                "EF2 = FT2 – ET2\n" +
                "EF2 = 172 – 152\n" +
                "EF2 = 289 – 225\n" +
                "EF2 = 64\n" +
                "EF = √64\n" +
                "EF = 8 cm\n" +
                "\n" +
                "Hitung panjang sisi segiempat (AB) yakni:\n" +
                "AB = 2 x EF\n" +
                "AB = 16 cm\n" +
                "Hitung luas alas yang bentuknya persegi yakni:\n" +
                "Luas alas = AB2\n" +
                "Luas alas = (16 cm)2\n" +
                "Luas alas = 256 cm2\n" +
                "Hitung luas segitiga yakni:\n" +
                "Luas ∆ = ½ x AB x FT\n" +
                "Luas ∆ = ½ x 16 x 17\n" +
                "Luas ∆ = 136 cm2\n" +
                "\n" +
                "Hitung luas permukaan limas:\n" +
                "Luas permukaan = Luas alas + 4 x Luas ∆\n" +
                "Luas permukaan = 256 cm2 + 4 x 136 cm2\n" +
                "Luas permukaan = 256 cm2 + 544 cm2\n" +
                "Luas permukaan = 800 cm2\n" +
                "Jadi luas permukaan limas tersebut adalah 800 cm2\n",
        "Panjang KO sama dengan setengah panjang KM yakni:\n" +
                "KO = ½ KM\n" +
                "\n" +
                "Panjang KM dapat dicari dengan menggunakanteorema Phytagoras yakni:\n" +
                "KM2 = KL2  + LM2\n" +
                "KM2 = 82  + 82\n" +
                "KM2 = 64 + 64\n" +
                "KM2 = 128\n" +
                "KM = 8√2 cm\n" +
                "\n" +
                "KO = ½ KM\n" +
                "KO = ½ x 8√2 cm\n" +
                "KO = 4√2 cm\n",
        "BF = ½ AB, maka panjang FT dapat dicari dengan menggunakan teorema Phytagoras yakni:\n" +
                "FT2 = BT2 - BF2\n" +
                "FT2 = 102 -  62\n" +
                "FT2 = 100 - 36\n" +
                "FT2 = 64\n" +
                "FT = 8 cm\n" +
                "\n" +
                "Panjang ET dapat juga dicari dengan menggunakan teorema Phytagoras, yakni:\n" +
                "ET2 = FT2  - EF2\n" +
                "ET2 = 82 - 62\n" +
                "ET2 = 64 - 36\n" +
                "ET2 = 28\n" +
                "ET = 2√7 cm\n"
    )

    private val listFinalQuestion = arrayListOf(
        "Panjang  diagonal  bidang  sebuah  kubus  adalah  6√2 cm. Volume kubus tersebut adalah … cm³.",
        "Sebuah kubus panjang rusuknya 8 cm, kemudian rusuk tersebut diperkecil sebesar ¾ kali panjang rusuk semula. Volume kubus setelah diperkecil adalah …. cm³.",
        "Keliling alas sebuah kubus 60 cm. Volume kubus itu adalah … cm³.",
        "Sebuah  kubus  memiliki  luas  permukaan  150  cm².  Maka, volume kubus tersebut adalah … cm³.",
        "Dua buah kubus mempunyai panjang rusuk masingmasing-masing  8  cm  dan  12  cm.  Perbandingan volume kedua kubus itu adalah …",

        "Volume balok dengan ukuran panjang 12 cm, lebar  8 cm, dan tinggi 5 cm adalah …",
        "Perbandingan  ukuran  panjang,  lebar,  dan  tinggi sebuah balok adalah  \uD835\uDC5D ∶  \uD835\uDC59 ∶  \uD835\uDC61  = 4 : 3 : 5, sedangkan luas permukaannya 846 cm².  Volume balok tersebut adalah …",
        "Seorang pedagang ikan hias ingin membuat sebuah kerangka akuarium dengan menggunakan aluminium. Kerangka tersebut berbentuk balok dengan ukuran 2 m x 1 m x 50 cm. Jika harga aluminium Rp30.000,00 per meter, maka biaya yang diperlukan untuk membuat kerangka akuarium tersebut adalah …",
        "Perbandingan panjang, lebar, dan tinggi  sebuah balok adalah 3 : 2 : 1. Jika volume balok 750 cm³, maka luas permukaan balok tersebut adalah … cm².",
        "Sebuah tempat air berbentuk balok berukuran 50 cm × 60 cm × 40 cm terisi air dua pertiga bagian. Air tersebut dipindah ke dalam sebuah tempat berbentuk kubus dengan panjang rusuk 50 cm. Tambahan air agar tempat  air berbentuk kubus penuh adalah …",

        "Alas sebuah prisma berbentuk belah ketupat dengan panjang sisi 13 cm. Panjang salah satu diagonal alas 10 cm, dan tinggi  prisma 10 cm. Volume  prisma adalah … cm³.",
        "Sebuah prisma dengan alas belah ketupat berukuran sisi 15 cm dan salah satu diagonalnya 18 cm. Jika panjang rusuk tegaknya 20 cm, maka volume prisma itu adalah … cm³.",
        "Sebuah  prisma  memiliki  alas  segitiga  siku-siku dengan panjang sisi-sisinya adalah 9 cm, 12 cm, dan 15 cm. Jika volume prisma tersebut 1.080 cm³, makatinggi prisma adalah … cm.",
        "Kolam renang mempunyai ukuran panjang 20 m dan lebar 8 m. Kedalaman air pada ujung kolam paling dangkal 1,2 m dan terus melandai sampai 2,5 m pada ujung paling dalam. Jika kolam renang diisi air hingga penuh, maka volume air dalam kolam renang tersebut adalah … liter.",
        "Gambar di atas adalah kubus dengan panjang rusuk 18 cm. Titik P dan S memenuhi perbandingan AP : PB = 2 : 1 dan DS : SC = 4 : 5. Volume prisma APSD.EQRH adalah … cm³.",

        "Alas sebuah limas berbentuk belah ketupat dengan keliling alas 52 cm dan panjang salah satu diagonalnya 24 cm. Jika tinggi  limas 21 cm, volume limas tersebut adalah … cm³.",
        "Alas limas berbentuk segitiga siku-siku  dengan panjang sisi 12 cm, 16 cm, dan 20 cm. Jika tinggi limas 21 cm, maka volume limas tersebut adalah … cm³.",
        "Volume sebuah limas yang alasnya berbentuk persegi adalah 320 cm³. Jika tinggi limas 15 cm, maka panjang rusuk alas limas itu adalah … cm.",
        "Perhatikan gambar limas persegi T.ABCD berikut. Jika  AC = BD 18 cm dan TC = 15 cm. Volume limas T.ABCD adalah … cm³.\n*catatan = luas alas dapat dicari dengan rumus luas belah ketupat",
        "Diketahui luas permukaan limas segiempat beraturan adalah 576 cm² dan luas alasnya 256 cm². Volume limas tersebut adalah … cm³."
    )

    private val listFinalOptionA = arrayListOf(
        "432√2",
        "512",
        "3.375",
        "25",
        "2 : 3",

        "25 cm³",
        "60 cm³",
        "Rp600.000,00",
        "22",
        "45.000 cm³",

        "1.800 cm³",
        "2.160      ",
        "20      ",
        "296.000",
        "3.600",

        "2.520",
        "480 cm³",
        "4 cm",
        "648",
        "512"
    )

    private val listFinalOptionB = arrayListOf(
        "108",
        "379",
        "3.425",
        "125",
        "4 : 9",

        "240 cm³",
        "600 cm³",
        "Rp450.000,00",
        "55",
        "50.000 cm³",

        "650 cm³",
        "4.320",
        "16",
        "29.600",
        "5.184",

        "840",
        "840 cm³",
        "6 cm",
        "810 ",
        "786"
    )

    private val listFinalOptionC = arrayListOf(
        "216√2",
        "216",
        "3.475 ",
        "100",
        "8 : 9",

        "196 cm³",
        "480 cm³",
        "Rp420.000,00",
        "220",
        "50.000 cm³",

        "1.200 cm³",
        "5.400",
        "12",
        "2.960",
        "2.160",

        "420",
        "672 cm³",
        "8 cm",
        "1296",
        "1.240"
    )

    private val listFinalOptionD = arrayListOf(
        "216",
        "64",
        "3.725 ",
        "200",
        "8 : 27",

        "480 cm³",
        "1.620 cm³",
        "Rp105.000,00",
        "550",
        "85.000 cm³",

        "600 cm³",
        "8.640",
        "8",
        "296",
        "3.240",

        "210",
        "1.008 cm³",
        "12 cm",
        "1.620",
        "1.536"
    )

    private val listFinalKey = arrayListOf(
        "d",
        "c",
        "a",
        "b",
        "d",

        "d",
        "d",
        "c",
        "d",
        "a",

        "c",
        "b",
        "a",
        "a",
        "d",

        "b",
        "c",
        "c",
        "b",
        "a"
    )

    private val listFinalExplanation = arrayListOf(
        "",
        "",
        "",
        "",
        "",

        "",
        "",
        "",
        "",
        "",

        "",
        "",
        "",
        "",
        "",

        "",
        "",
        "",
        "",
        ""
    )

    private val listCube: ArrayList<Question>
        get() {
            val list = arrayListOf<Question>()
            for (position in listCubeQuestion.indices) {
                val quiz = Question()
                quiz.question = listCubeQuestion[position]
                quiz.optionA = listCubeOptionA[position]
                quiz.optionB = listCubeOptionB[position]
                quiz.optionC = listCubeOptionC[position]
                quiz.optionD = listCubeOptionD[position]
                quiz.key = listCubeKey[position]
                quiz.explanation = listCubeExplanation[position]
                list.add(quiz)
            }
            return list
        }

    private val listPrism: ArrayList<Question>
        get() {
            val list = arrayListOf<Question>()
            for (position in listPrismQuestion.indices) {
                val quiz = Question()
                quiz.question = listPrismQuestion[position]
                quiz.optionA = listPrismOptionA[position]
                quiz.optionB = listPrismOptionB[position]
                quiz.optionC = listPrismOptionC[position]
                quiz.optionD = listPrismOptionD[position]
                quiz.key = listPrismKey[position]
                quiz.explanation = listPrismExplanation[position]
                list.add(quiz)
            }
            return list
        }

    private val listPyramid: ArrayList<Question>
        get() {
            val list = arrayListOf<Question>()
            for (position in listPyramidQuestion.indices) {
                val question = Question()
                question.question = listPyramidQuestion[position]
                question.optionA = listPyramidOptionA[position]
                question.optionB = listPyramidOptionB[position]
                question.optionC = listPyramidOptionC[position]
                question.optionD = listPyramidOptionD[position]
                question.key = listPyramidKey[position]
                question.explanation = listPyramidExplanation[position]
                list.add(question)
            }
            return list
        }

    private val listFinal: ArrayList<Question>
        get() {
            val list = arrayListOf<Question>()
            for (position in listFinalQuestion.indices) {
                val question = Question()
                question.question = listFinalQuestion[position]
                question.optionA = listFinalOptionA[position]
                question.optionB = listFinalOptionB[position]
                question.optionC = listFinalOptionC[position]
                question.optionD = listFinalOptionD[position]
                question.key = listFinalKey[position]
                question.explanation = listFinalExplanation[position]
                list.add(question)
            }
            return list
        }

    val allQuiz = arrayListOf(listCube, listPrism, listPyramid, listFinal)

//    private val list = arrayListOf(
//        "",
//        "",
//        "",
//        "",
//        "",
//        "",
//        "",
//        "",
//        "",
//        ""
//    )
}