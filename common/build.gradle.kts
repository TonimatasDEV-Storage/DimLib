val fabricLoaderVersion: String by extra
val midnightlibVersion: String by extra



dependencies {
    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    implementation("maven.modrinth:midnightlib:$midnightlibVersion-neoforge")
    implementation("net.fabricmc.fabric-api:fabric-api-base:2.0.3+ece063234e")
}

architectury {
    common("fabric", "neoforge")
}
