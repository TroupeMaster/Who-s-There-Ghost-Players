package net.mcreator.whosthere.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class GhostPlayersConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> NAMELIST;
	public static final ForgeConfigSpec.ConfigValue<Double> RECENTPLAYERNAMESCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> SPOOKYNAMECHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> LISTNAMECHANCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GENERATERANDOMNAME;
	public static final ForgeConfigSpec.ConfigValue<String> EMPTYPLAYERNAME;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOWUSELIST;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ONLYLIST;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SPAWNWHITEEYES;
	public static final ForgeConfigSpec.ConfigValue<Double> GHOSTSPAWNTIMER;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SPAWNEMPTYPLAYER;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> EMPTYPLAYERCANSPAWNSURFACE;
	public static final ForgeConfigSpec.ConfigValue<Double> WHITEEYESCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> GHOSTPLAYERSIZE;
	public static final ForgeConfigSpec.ConfigValue<Double> WHITEEYESSIZE;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERSIZE;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERSIZETOPLAYER;
	public static final ForgeConfigSpec.ConfigValue<Double> WHITEEYESDESPAWN;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERDESPAWN;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERWALKCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERAGGRESSIVECHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> WHITEEYESDESPAWNCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> RANDOMSOUNDEVENT;
	public static final ForgeConfigSpec.ConfigValue<Boolean> BLOCKBREAKINGSOUND;
	public static final ForgeConfigSpec.ConfigValue<Double> BLOCKBREAKINGCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> BLOCKBREAKINGDISTANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERPICKAXE;
	public static final ForgeConfigSpec.ConfigValue<Double> WHITEEYESJUMPSCARE;
	public static final ForgeConfigSpec.ConfigValue<Double> RANDOMSOUNDEVENTCHANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERWALKDISTANCE;
	public static final ForgeConfigSpec.ConfigValue<Double> EMPTYPLAYERRUNDISTANCE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> EMPTYPLAYERDENYSPAWNS;
	static {
		BUILDER.push("Names");
		NAMELIST = BUILDER.comment("A list of names ghost players will use").defineList("List of names", List.of(), entry -> true);
		RECENTPLAYERNAMESCHANCE = BUILDER.comment("The chance of picking recent player names (1 is 100%). Highest priority (default = 0.1)").define("Chance of a recent player name", (double) 0.1);
		SPOOKYNAMECHANCE = BUILDER.comment("The chance of a spooky name being chosen (1 is 100%). Medium priority (default = 0.3)").define("Chance of a spooky name", (double) 0.3);
		LISTNAMECHANCE = BUILDER.comment("The chance of a name from the list being chosen (1 is 100%). Lowest priority (default = 0.5)").define("Chance of a list name", (double) 0.5);
		GENERATERANDOMNAME = BUILDER.comment("If a random name should be generated when every other option fails (if false, will default to: .)").define("Generate a random name", true);
		EMPTYPLAYERNAME = BUILDER.comment("The name that empty players will use. Leave blank for no names").define("Empty Player name", "Player");
		BUILDER.pop();
		BUILDER.push("List");
		ALLOWUSELIST = BUILDER.comment("Whether the name list will be used or not").define("Allow the name list to be used", false);
		ONLYLIST = BUILDER.comment("Whether the name list is the only list that should be used or not").define("Only use the name list", false);
		BUILDER.pop();
		BUILDER.push("Spawns");
		SPAWNWHITEEYES = BUILDER.comment("If the white eyes should spawn").define("Spawn White Eyes", true);
		GHOSTSPAWNTIMER = BUILDER.comment("The timer before a ghost spawns in ticks (default = 1200)").define("Timer for Ghost Players", (double) 1200);
		SPAWNEMPTYPLAYER = BUILDER.comment("If empty steve/alex should spawn naturally").define("Spawn Empty Player", true);
		EMPTYPLAYERCHANCE = BUILDER.comment("The chance of an empty player spawning (default = 0.4) [1 is 100%]").define("Chance of an Empty Player spawning", (double) 0.4);
		EMPTYPLAYERCANSPAWNSURFACE = BUILDER.comment("If empty players should be able to spawn on the surface").define("Empty Players can spawn on the surface", false);
		WHITEEYESCHANCE = BUILDER.comment("The chance of a white eyes spawning instead of a ghost (default = 0.04) [1 is 100%]").define("Chance of a White Eyes spawning", (double) 0.04);
		GHOSTPLAYERSIZE = BUILDER.comment("The area in which a ghost player cannot spawn next to another one (in blocks, both directions. For one direction, divide by 2) [default = 80]").define("Separation between Ghost Players", (double) 80);
		WHITEEYESSIZE = BUILDER.comment("The area in which a white eyes cannot spawn next to another one (in blocks, both directions. For one direction, divide by 2) [default = 80]").define("Separation between White Eyes", (double) 100);
		EMPTYPLAYERSIZE = BUILDER.comment("The area in which an empty player cannot spawn next to another one (in blocks, both directions. For one direction, divide by 2) [default = 80]").define("Separation between Empty Players", (double) 80);
		EMPTYPLAYERSIZETOPLAYER = BUILDER.comment("The area in which an empty player cannot spawn next to the player (in blocks, both directions. For one direction, divide by 2) [default = 45]")
				.define("Separation between Empty Players and the player", (double) 45);
		WHITEEYESDESPAWN = BUILDER.comment("The time it takes before a white eyes despawns (default = 800) [in ticks]").define("Despawn time for White Eyes", (double) 800);
		EMPTYPLAYERDESPAWN = BUILDER.comment("The time it takes before an empty player despawns (default = 2400) [in ticks]").define("Despawn time for Empty Player", (double) 2400);
		EMPTYPLAYERWALKCHANCE = BUILDER.comment("The chance of an empty player walking towards the nearest player (default = 0.1) [1 is 100%]").define("Empty Player walking chance", (double) 0.1);
		EMPTYPLAYERAGGRESSIVECHANCE = BUILDER.comment("The chance of an empty player running towards the nearest player and attacking them (default = 0.1) [1 is 100%]").define("Empty Player aggressive chance", (double) 0.1);
		WHITEEYESDESPAWNCHANCE = BUILDER.comment("The chance of a white eyes cancelling the spawn (to make the entity rarer) (default = 0.5) [1 is 100%]").define("White Eyes despawn chance", (double) 0.5);
		BUILDER.pop();
		BUILDER.push("Misc");
		RANDOMSOUNDEVENT = BUILDER.comment("If random sounds should play from time-to-time while in caves").define("Do random sound event", true);
		BLOCKBREAKINGSOUND = BUILDER.comment("If sounds of blocks being broken should play when a ghost players spawns").define("Do block breaking sounds", true);
		BLOCKBREAKINGCHANCE = BUILDER.comment("The chance to play block breaking sounds when a ghost player spawns (default = 0.1) [1 is 100%]").define("Chance of block breaking sounds", (double) 0.1);
		BLOCKBREAKINGDISTANCE = BUILDER.comment("The attenuation distance of the block breaking sounds, how far you can hear them (default = 3) [value of config * 16 is the true distance]").define("Attenuation of the breaking sounds", (double) 3);
		EMPTYPLAYERPICKAXE = BUILDER.comment("The chance of an empty player spawning with a pickaxe (default = 0.25) [1 is 100%]").define("Chance of an Empty Player spawning with a pickaxe", (double) 0.25);
		WHITEEYESJUMPSCARE = BUILDER.comment("The chance of a white eyes jumpscaring the player (default = 0.75) [1 is 100%]").define("Chance for White Eyes to jumpscare", (double) 0.75);
		RANDOMSOUNDEVENTCHANCE = BUILDER.comment("The chance for a random sound event to play each tick (default = 0.001) [1 is 100%]").define("Chance for a random sound event to play", (double) 0.001);
		EMPTYPLAYERWALKDISTANCE = BUILDER.comment("How close the player needs to be to the empty player for the entity to start walking towards the player (default = 60) [in blocks, in an square area]").define("Empty Player walk distance",
				(double) 60);
		EMPTYPLAYERRUNDISTANCE = BUILDER.comment("How close the player needs to be to the empty player for the entity to start sprinting towards the player (default = 28) [in blocks, in an square area]").define("Empty Player sprint distance",
				(double) 28);
		EMPTYPLAYERDENYSPAWNS = BUILDER.comment("If empty players should stop other mobs from spawning when they are around (default = false)").define("Empty Players deny spawning", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
