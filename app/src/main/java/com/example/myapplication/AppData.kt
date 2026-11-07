package com.example.myapplication

import androidx.annotation.DrawableRes
data class StoreSection(val id: String, val type: String, val title: String)

data class StoreApp(
    val id: String,
    val title: String,
    val category: String,
    val rating: Double,
    val section_id: String,
    @DrawableRes val iconRes: Int,
    @DrawableRes val bannerRes: Int,
    val description: String,
    val installSizeMb: Int
)

object SampleApps {
    val sections: List<StoreSection> = listOf(
        StoreSection("s1", "list", "Recommended for You"),
        StoreSection("s2", "grid", "Learn Something New"),
        StoreSection("s3", "grid", "Games You Might Love"),
        StoreSection("s4", "list", "Top Picks"),
        StoreSection("s5", "grid", "Everyday Essentials"),
        StoreSection("s6", "grid", "Explore More Apps")
    )

    val apps: List<StoreApp> = listOf(
        StoreApp("app1", "NotePro", "Productivity", 4.7, "s1", R.drawable.notepro_icon, R.drawable.notepro_banner, "Take notes, create lists, and sync your ideas every day.", 28),
        StoreApp("app2", "FitLife", "Health & Fitness", 4.6, "s1", R.drawable.fitlife_icon, R.drawable.fitlife_banner, "Track workouts, wellness goals, and healthy habits.", 45),
        StoreApp("app3", "StudyHub", "Education", 4.8, "s1", R.drawable.studyhub_icon, R.drawable.studyhub_banner, "Access bite-sized courses, lessons, and practice anytime.", 52),
        StoreApp("app4", "TravelGo", "Travel & Local", 4.5, "s2", R.drawable.travelgo_icon, R.drawable.travelgo_banner, "Discover destinations, plan itineraries, and save trips.", 60),
        StoreApp("app5", "Foodie", "Food & Drink", 4.4, "s2", R.drawable.foodie_icon, R.drawable.foodie_banner, "Explore delicious dishes and exciting recipes.", 36),
        StoreApp("app6", "MoviePlus", "Entertainment", 4.5, "s2", R.drawable.movieplus_icon, R.drawable.movieplus_banner, "Discover movies, trailers, and build your watchlist.", 72),
        StoreApp("app7", "MoneyMate", "Finance", 4.9, "s2", R.drawable.moneymate_icon, R.drawable.moneymate_banner, "Manage spending, budgets, and savings goals.", 31),
        StoreApp("app8", "WeatherNow", "Weather", 4.3, "s2", R.drawable.weathernow_icon, R.drawable.weathernow_banner, "Get hourly weather forecasts and air quality updates.", 24),
        StoreApp("app9", "MindGarden", "Health & Fitness", 4.7, "s2", R.drawable.mindgarden_icon, R.drawable.mindgarden_banner, "Meditate, unwind, and improve your sleep.", 40),
        StoreApp("app10", "SnapEdit", "Photography", 4.6, "s2", R.drawable.snapedit_icon, R.drawable.snapedit_banner, "Edit photos with filters and creative tools.", 88),
        StoreApp("app11", "QuickCart", "Shopping", 4.2, "s2", R.drawable.quickcart_icon, R.drawable.quickcart_banner, "Shop conveniently and track your orders.", 55),
        StoreApp("app12", "TuneWave", "Music & Audio", 4.8, "s2", R.drawable.tunewave_icon, R.drawable.tunewave_banner, "Listen to podcasts and organize your audio playlists.", 63),
        StoreApp("app13", "TaskFlow", "Productivity", 4.5, "s3", R.drawable.taskflow_icon, R.drawable.taskflow_banner, "Plan tasks and monitor your progress.", 73),
        StoreApp("app14", "FocusClock", "Productivity", 4.7, "s3", R.drawable.focusclock_icon, R.drawable.focusclock_banner, "Stay focused with Pomodoro timers.", 103),
        StoreApp("app15", "ScanBox", "Tools", 4.0, "s3", R.drawable.scanbox_icon, R.drawable.scanbox_banner, "Scan documents and save them as PDFs.", 123),
        StoreApp("app16", "WordNest", "Education", 4.2, "s3", R.drawable.wordnest_icon, R.drawable.wordnest_banner, "Learn English vocabulary through fun games.", 97),
        StoreApp("app17", "MathQuest", "Education", 4.6, "s3", R.drawable.mathquest_icon, R.drawable.mathquest_banner, "Challenge yourself with engaging math exercises.", 109),
        StoreApp("app18", "CodeCamp", "Education", 4.1, "s3", R.drawable.codecamp_icon, R.drawable.codecamp_banner, "Practice programming with short coding challenges.", 69),
        StoreApp("app19", "BookBird", "Books & Reference", 4.8, "s3", R.drawable.bookbird_icon, R.drawable.bookbird_banner, "Read books and save your favorite quotes.", 120),
        StoreApp("app20", "MapTrail", "Travel & Local", 4.1, "s3", R.drawable.maptrail_icon, R.drawable.maptrail_banner, "Map your trips and explore scenic trails.", 77),
        StoreApp("app21", "CityGuide", "Travel & Local", 4.2, "s3", R.drawable.cityguide_icon, R.drawable.cityguide_banner, "Find interesting places around the city.", 25),
        StoreApp("app22", "ChefCook", "Food & Drink", 4.4, "s4", R.drawable.chefcook_icon, R.drawable.chefcook_banner, "Learn to cook with step-by-step recipes.", 38),
        StoreApp("app23", "MealPlanner", "Food & Drink", 4.5, "s4", R.drawable.mealplanner_icon, R.drawable.mealplanner_banner, "Plan meals and create grocery lists.", 27),
        StoreApp("app24", "YogaFlow", "Health & Fitness", 4.8, "s4", R.drawable.yogaflow_icon, R.drawable.yogaflow_banner, "Practice yoga at home at your own level.", 78),
        StoreApp("app25", "StepBuddy", "Health & Fitness", 4.3, "s5", R.drawable.stepbuddy_icon, R.drawable.stepbuddy_banner, "Count steps and set daily activity goals.", 119),
        StoreApp("app26", "SleepWave", "Health & Fitness", 4.4, "s5", R.drawable.sleepwave_icon, R.drawable.sleepwave_banner, "Relax with calming sounds for better sleep.", 85),
        StoreApp("app27", "BudgetBee", "Finance", 4.2, "s5", R.drawable.budgetbee_icon, R.drawable.budgetbee_banner, "Track income and expenses with clear charts.", 45),
        StoreApp("app28", "BillTrack", "Finance", 4.5, "s5", R.drawable.billtrack_icon, R.drawable.billtrack_banner, "Get reminders for recurring bills and payments.", 61),
        StoreApp("app29", "PhotoFox", "Photography", 4.4, "s5", R.drawable.photofox_icon, R.drawable.photofox_banner, "Create photo filters and make quick edits.", 100),
        StoreApp("app30", "DrawPad", "Art & Design", 4.2, "s5", R.drawable.drawpad_icon, R.drawable.drawpad_banner, "Draw digital artwork with a variety of brushes.", 90),
        StoreApp("app31", "PixelCraft", "Art & Design", 4.3, "s5", R.drawable.pixelcraft_icon, R.drawable.pixelcraft_banner, "Design pixel art and share your creations.", 78),
        StoreApp("app32", "SoundBox", "Music & Audio", 4.1, "s5", R.drawable.soundbox_icon, R.drawable.soundbox_banner, "Play and organize your favorite music.", 21),
        StoreApp("app33", "PodTalk", "Music & Audio", 4.8, "s5", R.drawable.podtalk_icon, R.drawable.podtalk_banner, "Discover podcasts across a variety of topics.", 80),
        StoreApp("app34", "GameForge", "Games", 4.8, "s6", R.drawable.gameforge_icon, R.drawable.gameforge_banner, "Solve puzzles and explore a fantasy world.", 106),
        StoreApp("app35", "BlockPuzzle", "Games", 4.5, "s6", R.drawable.blockpuzzle_icon, R.drawable.blockpuzzle_banner, "Arrange blocks and score points across levels.", 66),
        StoreApp("app36", "SpeedRacer", "Games", 4.3, "s6", R.drawable.speedracer_icon, R.drawable.speedracer_banner, "Race on exciting tracks at high speed.", 97),
        StoreApp("app37", "SpaceJump", "Games", 4.0, "s6", R.drawable.spacejump_icon, R.drawable.spacejump_banner, "Dodge obstacles as you travel across planets.", 73),
        StoreApp("app38", "ChessMate", "Games", 4.7, "s6", R.drawable.chessmate_icon, R.drawable.chessmate_banner, "Practice chess against AI and solve chess puzzles.", 42),
        StoreApp("app39", "PetPal", "Games", 4.7, "s6", R.drawable.petpal_icon, R.drawable.petpal_banner, "Care for virtual pets and earn rewards.", 98),
        StoreApp("app40", "ShopWise", "Shopping", 4.3, "s6", R.drawable.shopwise_icon, R.drawable.shopwise_banner, "Compare products and organize shopping lists.", 126),
        StoreApp("app41", "GardenLog", "Lifestyle", 4.6, "s6", R.drawable.gardenlog_icon, R.drawable.gardenlog_banner, "Grow a thriving garden with plant care reminders.", 48),
        StoreApp("app42", "StarAtlas", "Education", 4.6, "s6", R.drawable.staratlas_icon, R.drawable.staratlas_banner, "Explore stars, planets, and constellations.", 48)
    )

    fun appsInSection(sectionId: String): List<StoreApp> =
        apps.filter { it.section_id == sectionId }
}
