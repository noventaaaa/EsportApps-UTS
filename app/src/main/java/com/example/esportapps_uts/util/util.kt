package com.example.esportapps_uts.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.esportapps_uts.R
import com.example.esportapps_uts.model.Achievement
import com.example.esportapps_uts.model.Game
import com.example.esportapps_uts.model.GameDatabase
import com.example.esportapps_uts.model.Proposal
import com.example.esportapps_uts.model.Schedule
import com.example.esportapps_uts.model.Team
import com.squareup.picasso.Picasso


val DB_NAME = "esport"


fun buildDB(context: Context): GameDatabase {
    return Room.databaseBuilder(
        context,
        GameDatabase::class.java,
        DB_NAME
    )
        .addMigrations(MIGRATION_1_2)
        .fallbackToDestructiveMigration()
        .build()
}


val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Game ADD COLUMN photoUrl TEXT")
    }
}


fun ImageView.loadImage(url: String?, progressBar: ProgressBar?) {
    progressBar?.visibility = View.VISIBLE
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.baseline_person_24)
        .into(this, object : com.squareup.picasso.Callback {
            override fun onSuccess() {
                progressBar?.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                progressBar?.visibility = View.GONE
            }
        })
}


@BindingAdapter("imageUrl", "progressBar", requireAll = false)
fun bindImageWithProgress(view: ImageView, url: String?, progressBar: ProgressBar?) {
    view.loadImage(url, progressBar)
}

val listWePlay = listOf(
    Game(
        name = "Mobile Legends",
        description = "A popular multiplayer online battle arena game",
        photoUrl = "https://www.blibli.com/friends-backend/wp-content/uploads/2024/03/B111518-Cover-karakter-ml-scaled.jpg"
    ),
    Game(
        name = "PUBG Mobile",
        description = "A famous battle royale game",
        photoUrl = "https://news.codashop.com/id/wp-content/uploads/sites/4/2023/07/PUBG-Mobile-and-PUBG-PC.jpg"
    ),
    Game(
        name = "Valorant",
        description = "A tactical first-person shooter",
        photoUrl = "https://hasagi.gg/wp-content/uploads/2024/09/4ebcb533-e184-42f3-833b-9aa47a81f39e.jpg"
    ),
    Game(
        name = "Call of Duty Mobile",
        description = "A mobile version of the iconic shooter franchise",
        photoUrl = "https://codm.garena.com/static/images/Main-page/P1/main-kv.jpg"
    ),
    Game(
        name = "Free Fire",
        description = "A fast-paced survival shooter game",
        photoUrl = "https://asset-2.tstatic.net/palu/foto/bank/images/FF-Free-Fire.jpg"
    )
)

val listAchievements = listOf(
    Achievement(
        idgame = 1,
        name = "Mobile Legends: Champion of MPL Season 11",
        description = "Team A achieved first place in MPL Season 11.",
        year = 2023,
        team = "Team A"
    ),
    Achievement(
        idgame = 1,
        name = "Mobile Legends: Best Teamwork Award",
        description = "Awarded for outstanding teamwork in MPL.",
        year = 2022,
        team = "Team B"
    ),
    Achievement(
        idgame = 2,
        name = "PUBG Mobile: World Champion",
        description = "Secured the World Championship title in PUBG Mobile.",
        year = 2023,
        team = "Team C"
    ),
    Achievement(
        idgame = 2,
        name = "PUBG Mobile: Best Solo Performance",
        description = "Awarded for the best solo gameplay in PUBG tournaments.",
        year = 2021,
        team = "Team D"
    ),
    Achievement(
        idgame = 3,
        name = "Valorant: Regional Valorant Showdown Winner",
        description = "Won the regional Valorant showdown tournament.",
        year = 2023,
        team = "Team E"
    ),
    Achievement(
        idgame = 3,
        name = "Valorant: Best Defensive Team",
        description = "Awarded for the best defensive strategies in Valorant tournaments.",
        year = 2024,
        team = "Team F"
    ),
    Achievement(
        idgame = 4,
        name = "Call of Duty Mobile: Most Consistent Team",
        description = "Recognized for consistent performance across tournaments.",
        year = 2022,
        team = "Team G"
    ),
    Achievement(
        idgame = 4,
        name = "Call of Duty Mobile: MVP of the Year",
        description = "Awarded to the most valuable player of the year.",
        year = 2023,
        team = "Team H"
    ),
    Achievement(
        idgame = 5,
        name = "Free Fire: Champion of the Free Fire World Series",
        description = "Won the Free Fire World Series tournament.",
        year = 2023,
        team = "Team I"
    ),
    Achievement(
        idgame = 5,
        name = "Free Fire: Best Strategy Award",
        description = "Awarded for innovative strategies in Free Fire tournaments.",
        year = 2022,
        team = "Team J"
    )
)

val listTeams = listOf(
    // Team A
    Team(name = "ShadowStrike", role = "Duelist", photoUrl = "https://example.com/image1.jpg", teamGroup = "Team A"),
    Team(name = "ViperX", role = "Controller", photoUrl = "https://example.com/image2.jpg", teamGroup = "Team A"),

    // Team B
    Team(name = "BladeNova", role = "Sentinel", photoUrl = "https://example.com/image3.jpg", teamGroup = "Team B"),
    Team(name = "StormGuard", role = "Support", photoUrl = "https://example.com/image4.jpg", teamGroup = "Team B"),

    // Team C
    Team(name = "Stealth", role = "Strategist", photoUrl = "https://example.com/image5.jpg", teamGroup = "Team C"),
    Team(name = "ShadowCaster", role = "Sniper", photoUrl = "https://example.com/image6.jpg", teamGroup = "Team C"),

    // Team D
    Team(name = "Phoenix", role = "Leader", photoUrl = "https://example.com/image7.jpg", teamGroup = "Team D"),
    Team(name = "IronFist", role = "Tank", photoUrl = "https://example.com/image8.jpg", teamGroup = "Team D"),

    // Team E
    Team(name = "AceHunter", role = "Initiator", photoUrl = "https://example.com/image9.jpg", teamGroup = "Team E"),
    Team(name = "Vortex", role = "Defender", photoUrl = "https://example.com/image10.jpg", teamGroup = "Team E"),

    // Team F
    Team(name = "IceBlaze", role = "Scout", photoUrl = "https://example.com/image11.jpg", teamGroup = "Team F"),
    Team(name = "DarkShadow", role = "Lurker", photoUrl = "https://example.com/image12.jpg", teamGroup = "Team F"),

    // Team G
    Team(name = "Thunder", role = "Flanker", photoUrl = "https://example.com/image13.jpg", teamGroup = "Team G"),
    Team(name = "RogueWolf", role = "Sniper", photoUrl = "https://example.com/image14.jpg", teamGroup = "Team G"),

    // Team H
    Team(name = "DragonFury", role = "Support", photoUrl = "https://example.com/image15.jpg", teamGroup = "Team H"),
    Team(name = "WarriorX", role = "Assault", photoUrl = "https://example.com/image16.jpg", teamGroup = "Team H"),

    // Team I
    Team(name = "NovaStar", role = "Leader", photoUrl = "https://example.com/image17.jpg", teamGroup = "Team I"),
    Team(name = "ShadowWing", role = "Recon", photoUrl = "https://example.com/image18.jpg", teamGroup = "Team I"),

    // Team J
    Team(name = "FrostBite", role = "Sniper", photoUrl = "https://example.com/image19.jpg", teamGroup = "Team J"),
    Team(name = "SteelBlaze", role = "Tank", photoUrl = "https://example.com/image20.jpg", teamGroup = "Team J")
)


val listProposal = listOf(
    Proposal(gameName = "League of Legends", teamName = "Team Alpha", reason = "I have strong strategic skills", status = "WAITING"),
    Proposal(gameName = "League of Legends", teamName = "Team Bravo", reason = "I excel in teamwork", status = "DECLINED"),
    Proposal(gameName = "Mobile Legends", teamName = "Team Delta", reason = "I have years of experience", status = "GRANTED")
)

val listSchedule = listOf(
    Schedule(eventDate = "04", eventMonth = "DEC", eventName = "Fortnite Invitational", teamName = "Fortnite - Team A"),
    Schedule(eventDate = "10", eventMonth = "JAN", eventName = "Valorant Finals", teamName = "Valorant - Team B"),
    Schedule(eventDate = "22", eventMonth = "FEB", eventName = "CS:GO Major", teamName = "CSGO - Team C")
)


fun getTeamsByGameId(idgame: Int): List<String> {
    return listAchievements
        .filter { it.idgame == idgame }
        .mapNotNull { it.team }
        .distinct()
}



