package com.example.hw5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class NewsFragment(private var fragmentButtonListener: Adapter.FragmentButtonListener?,
var fragmentLikeListener: Adapter.FragmentLikeListener?) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater
            .inflate(R.layout.page, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        adapter = Adapter(newsGenerator(), fragmentButtonListener, fragmentLikeListener)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        return rootView
    }

    private fun newsGenerator(): MutableList<News> {
        val items: MutableList<News> = ArrayList()
        val news1 = News(
            1,
            "nikonrussia",
            "October 13, 2019",
            R.drawable.profile1,
            54344,
            R.drawable.post1,
            """
                Как ведут себя животные, когда на них никто не смотрит? Например, наслаждаются ароматом летних цветов! 🌻 «Я люблю цветы и животных и всегда хотел объединить их в одном кадре, — делится @dickvanduijn. — Я постоянно ищу способы запечатлеть природу в ее нетронутом виде. Сусликов во время съемок было много, поэтому сфотографировать их было несложно. Но, чтобы запечатлеть их с цветами, потребовалось много терпения. И когда я заметил, как суслик стал нюхать цветок и зарылся в его лепестки, я понял, что это будет лучшим кадром в моей жизни!»
                Камера: #Nikon #D810
                Объектив: AF-S #NIKKOR 500mm f/4G ED VR
                Диафрагма: f/7.1
                Выдержка: 1/1250
                ISO: 640
                Фокусное расстояние: 500 мм
                Автор: @dickvanduijn
                #Nikon #NikonRussia #NikonPhotography #Nikon_animal #Никон #Nikon_анималистика #анималистика
                """
        )
        items.add(news1)
        val news2 = News(
            2,
            "selenationgomez",
            "December 3, 2019",
            R.drawable.profile2,
            5402,
            R.drawable.post2,
            "Selamm ♥"
        )
        items.add(news2)
        val news3 = News(
            3,
            "getteggroup",
            "May 15, 2019",
            R.drawable.profile3,
            21010,
            R.drawable.post3,
            "Хочу \uD83E\uDD24"
        )
        items.add(news3)
        val news4 = News(
            4,
            "tiffany801.gg",
            "May 31, 2018",
            R.drawable.profile4,
            1396,
            R.drawable.post4,
            """
                She never made us disappointed in the style of her fashion 🌠❤ @tiffanyyoungofficial .
                I miss you , miss you like crazy , miss you Tiffany ❤ ❤ 💕 @tiffanyyoungofficial . ❤ ❤ ❤ ❤ ❤ ❤❤❤❤❤❤❤❤❤❤❤ @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial ❤❤❤❤❤❤❤❤❤❤❤❤❤ ❤ ❤ ❤ ❤ ❤
                _____________________
                #Tiffany #Miyoung #Sephanie #HwangMiYoung #StephanieHwang #TiffanyHwang #TiffanyYoung #GirlsGeneration #GG #SNSD #SoShi #Ot9 #S9 #Sone #Fanytastic #kpop #like4like #kpop #for4for #tiffany801.gg
                """
        )
        items.add(news4)
        val news5 = News(
            5,
            "randomemss",
            "April 29, 2019",
            R.drawable.profile5,
            11763,
            R.drawable.post5,
            "Как говорится, чёрный юмор как еда... #мем #меми #мемы #шутка #шутки #шутеечка #шутказа300 #юмор #гумор #ржачь #ржака #шуткаминутка #смешное #смех #жарти #мемы2019 #шуткадня #смешно #угар #смешнодослез #угар #мемыукраина #мемчики #мемасики #поржать"
        )
        items.add(news5)
        val news6 = News(
            6,
            "tiffanyyoungofficial",
            "March 27, 2019",
            R.drawable.profile6,
            392352,
            R.drawable.post6,
            """
                이 앨범을 만들면서, 많은 결정과 인내가 필요했던 순간마다 용기를낼수 있었던건 좋은 음악을 갖고 다시 여러분에게 돌아가야한다 라는 간절한 목표가있었기 때문인 것 같아요. 멀리 떠나있어도 진심이 담긴 음악이면  제 마음을 알아줄거라는것을 의심한적 없어요. 단지 종이한장일 뿐일수도있지만, 이 PLATINUM 💿✨ 이라는 의미가 지난 1년동안 포기하고 싶은 순간마다 여러분을 떠올리면서 다시일어섰던 제가 틀리지않았다는 것을 칭찬하고 안아주는 것 같아요. 내가 다시 돌아와야 하는 이유가 되어줘서, 다시 일어서고 다시 음악할 수 있는 이유가되어 준것 그것 하나만으로도 고마운데, 이렇게 큰 선물을 줘서 너무고마워요. 계속 의심하지않고 좋은 음악 만들어서 보답할게요.
                
                Last night singing LIPS ON LIPS for you in SEOUL felt like a dream 💋 & it still does bc i found out that YOU made the cd go PLATINUM in a WEEK !!!!!!!!! 🙏 사랑해사랑해사랑해🎵
                """
        )
        items.add(news6)
        val news7 = News(
            7,
            "taylorswift",
            "March 15, 2019",
            R.drawable.profile7,
            1596668,
            R.drawable.post7,
            "\uD83E\uDD8B \uD83D\uDC97 \uD83D\uDCF8 @presleyannphoto"
        )
        items.add(news7)
        val news8 = News(
            8,
            "kbtu.spirit",
            "November 20, 2018",
            R.drawable.profile8,
            181,
            R.drawable.post8,
            """
                вся жизнь в десятом пункте
                лайк и читаем дальше!
                ВЕЩИ, КОТОРЫЕ НАДО СДЕЛАТЬ, после поступления в КБТУ:
                1. Выложить в инстаграм фотку здания КБТУ с подписью: «поступил/теперь студент/ ну здравствуй»
                2. Написать в био интаграме "KBTU Student"
                3. Простоять в огромной очереди за книжками
                4. Так и не открыть ни одну книжку, сдать обратно
                5. Неудачно получиться на студенческом id
                6. Сходить на посвящение
                7. Разочароваться в студенческой жизни
                8. Рассказывать всем, как сложно учиться в КБТУ
                9. Выкладывать стори о том, как сложно учиться 24/7
                10. Страдать
                11. Расписаться в аттендансе за друга
                12. Повторить пункт 11
                13. Повторить пункт 12
                14. Спалиться перед учителем с подписями и всем классом получить absent
                15. Повторить пункт 10
                16. Покупать кофе каждое утро на 1 или 3 Толе би
                17. Прогуливать пары, веселиться до 15 недели
                16. Следующие три недели после повторять пункт 10
                #кбту #студентыкбту #гадалкакбту
                #духкбту #предсказаниеотРоксаны #гороскопдлястудентов #бш #BS #Фит #fit #ise #мшэ #ноцхи #фэнги #fogi #kma #кма #cecmc #мкм @kbtu_gov
                """
        )
        items.add(news8)
        val news9 = News(
            9,
            "mems__group",
            "January 3",
            R.drawable.profile9,
            8474,
            R.drawable.post9,
            "\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02"
        )
        items.add(news9)
        val news10 = News(
            10,
            "baby.yoda.memes_",
            "January 6",
            R.drawable.profile10,
            10716,
            R.drawable.post10,
            """
                I sleep like a baby (yoda) 😴 💤 🛏 .
                .
                Follow @baby.yoda.memes__ for more! 💚
                .
                .
                #yoda #yodamemes #babyyoda #babyyodamemes #starwars #themandalorian #mando #mandalorian #disney #disneyplus #cute #repost #riseofskywalker #lucasfilm #adorable #funny #memes #prequelmemes #jedi #force #theforce #new #rebelforceradio #relatable #relevant #starwarsclonewars #DaveFiloni #thisIsTheWay TheChild
                """
        )
        items.add(news10)
        val news11 = News(
            11,
            "feminist",
            "March 6",
            R.drawable.profile11,
            18857,
            R.drawable.post11,
            "\uD83E\uDD8B\uD83C\uDF38\uD83D\uDDA4 I love it \uD83D\uDDA4\uD83C\uDF38\uD83E\uDD8B"
        )
        items.add(news11)
        val news12 = News(
            12,
            "polymathematica",
            "February 20",
            R.drawable.profile12,
            25809,
            R.drawable.post12,
            """
                Best example ever 😀😀😀😀
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                .
                
                #Repost @jee.memes @scaleemael
                • • • • • •
                
                #mathisfun #engineeringstudent #computerscience #math #physics #checkmate #engineeringmemes #mathmemes #computer #maths  #mathmeme #matematica #geometry #mathmeme #estudos #mathstudents  #study  #estudante #engenharia #blackhole #scientist  #scienceisfun #matematicas #engineering #nerd #calculus  #geometry #mathjokes
                """
        )
        items.add(news12)
        val news13 = News(
            13,
            "e.l.c.u.c.u.y",
            "January 12",
            R.drawable.profile13,
            6792,
            R.drawable.post13,
            "\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02"
        )
        items.add(news13)
        val news14 = News(
            14,
            "astrologpress",
            "January 12",
            R.drawable.profile14,
            7300,
            R.drawable.post14,
            """
                РУБРИКА - ASTROГРАФИКА. Поддержите нас лайком ❤️, чтобы мы не потеряли друг друга.
                ⠀
                А какой Ваш любимый камень?
                ⠀
                С радостью увидим нашу ASTROГРАФИКУ в Ваших Сторис 📲 - и не забудьте отметить @astrologpress 😉
                
                original by @sanctuarywrld 
                """
        )
        items.add(news14)
        val news15 = News(
            15,
            "9gag",
            "January 8",
            R.drawable.profile15,
            944583,
            R.drawable.post15,
            """
                Подтвержденный
                If only this little fluff was real
                ✍🏻 @art_of_silverfox
                -
                #doodle #fox #fluff #9gag
                """
        )
        items.add(news15)
        val news16 = News(
            16,
            "deeryoon.hk",
            "December 3, 2019",
            R.drawable.profile16,
            3016,
            R.drawable.post16,
            """
                🌸COSMO時尚美麗慶典🌸 cr.logo,limyoonabar
                @yoona__lim #yoona #limyoona #yoona__lim #yoonalim #snsd #soshi #sone #hksone #girlsgeneration #deeryoonhk
                """
        )
        items.add(news16)
        val news17 = News(
            17,
            "comely.vintage",
            "December 9, 2019",
            R.drawable.profile17,
            9393,
            R.drawable.post17,
            """
                𝐼𝓃𝓈𝓅𝒾𝓇𝒶𝓉𝒾𝑜𝓃
                #comelyvintage
                ~ via: @samsonthedood
                """
        )
        items.add(news17)
        val news18 = News(
            18,
            "edsm_kdrama",
            "June 7, 2019",
            R.drawable.profile18,
            2260,
            R.drawable.post18,
            """
                Yang tadinya benci banget ama laki yang ngerokok
                Tapi kalo om akuh buat pengecualian kok😋🤣🤣🤣
                Keliatan Laki banget Om😍😍😍
                CR : andylah tumblr account
                #그녀의사생활 #HerPrivateLife #TVNDrama
                #박민영 #parkminyoung #SungDukMi
                #김재욱 #KimJaeWook #RyanGold
                #정제원 #JungJaeWon #ChaShiAhn
                #안보현 #AhnBoHyun #NamEunKi
                #김보라 #KimBoRa #Cindy
                #Wednesday #Thursday
                #누나팬닷컴
                """
        )
        items.add(news18)
        val news19 = News(
            19,
            "lildickygram",
            "April 19, 2019",
            R.drawable.profile19,
            3003426,
            R.drawable.post19,
            "\uD83C\uDF0D out now #WeLoveTheEarth"
        )
        items.add(news19)
        val news20 = News(
            20,
            "artjumbo",
            "December 23, 2018",
            R.drawable.profile20,
            5734,
            R.drawable.post20,
            """
                Toothless celebrities
                Tag a friend and say nothing 👇
                
                Follow @artjumbo @artjumbo ‍🎨
                """
        )
        items.add(news20)
        return items
    }

    fun removeLike(news: News){
        adapter.removeLike(news)
    }

}