package com.mc3699.smparch.registry;

import com.mc3699.smparch.SMPArch;
import com.mc3699.smparch.archetype.aidenman.PhotosynthesisAbility;
import com.mc3699.smparch.archetype.ariytwo6.AriyhomeAbility;
import com.mc3699.smparch.archetype.ariytwo6.GroundpunchAbility;
import com.mc3699.smparch.archetype.ariytwo6.StrengthrandAbility;
import com.mc3699.smparch.archetype.ariytwo6.WaterjumpAbility;
import com.mc3699.smparch.archetype.arveral.TendrilsAbility;
import com.mc3699.smparch.archetype.blox.BloxDashAbility;
import com.mc3699.smparch.archetype.blox.BloxShieldAbility;
import com.mc3699.smparch.archetype.blox.BloxSpeedAbility;
import com.mc3699.smparch.archetype.emberflame65.*;
import com.mc3699.smparch.archetype.eyae.SummonBigHandsAbility;
import com.mc3699.smparch.archetype.firelight.DragonLeapAbility;
import com.mc3699.smparch.archetype.growth.GrowthDebuff;
import com.mc3699.smparch.archetype.growth.NatureGiftAbility;
import com.mc3699.smparch.archetype.growth.NatureSightAbility;
import com.mc3699.smparch.archetype.heaven.BlackoutAbility;
import com.mc3699.smparch.archetype.heaven.ContagionAbility;
import com.mc3699.smparch.archetype.heaven.DisruptionAbility;
import com.mc3699.smparch.archetype.heaven.OverheatAbility;
import com.mc3699.smparch.archetype.john_ultrakill.UltrakillDashAbility;
import com.mc3699.smparch.archetype.john_ultrakill.UltrakillFeedbackerAbility;
import com.mc3699.smparch.archetype.john_ultrakill.UltrakillSlamAbility;
import com.mc3699.smparch.archetype.miku.*;
import com.mc3699.smparch.archetype.nightheart.RandomTeleportAbility;
import com.mc3699.smparch.archetype.pencil_html.EndStepAbility;
import com.mc3699.smparch.archetype.teebee.AmplifyAbility;
import com.mc3699.smparch.archetype.teebee.ReverseAbility;
import com.mc3699.smparch.archetype.terra.HeartbeatAbility;
import com.mc3699.smparch.archetype.terra.SolarSurgeAbility;
import com.mc3699.smparch.archetype.zorgoliath.HarkenTrueSight;
import com.mc3699.smparch.archetype.zorgoliath.HarkenerSilentDash;
import com.mc3699.smparch.archetype.zorgoliath.HarkenerWrathfulAdvance;
import com.mc3699.smparch.generic_abilities.*;
import net.mc3699.provenance.ProvenanceRegistries;
import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SMPAbilities {

    public static final DeferredRegister<BaseAbility> ABILITIES =
            DeferredRegister.create(ProvenanceRegistries.ABILITY_REGISTRY, SMPArch.MODID);

    public static final Supplier<RandomTeleportAbility> RANDOM_TELEPORT =
            ABILITIES.register("random_teleport", RandomTeleportAbility::new);

    public static final Supplier<ContagionAbility> CONTAGION =
            ABILITIES.register("contagion", ContagionAbility::new);

    public static final Supplier<OverheatAbility> OVERHEAT =
            ABILITIES.register("overheat", OverheatAbility::new);

    public static final Supplier<DashAbility> DASH =
            ABILITIES.register("dash", DashAbility::new);

    public static final Supplier<DragonLeapAbility> DRAGON_LEAP =
            ABILITIES.register("dragon_leap", DragonLeapAbility::new);

    public static final Supplier<WallClimbAbility> WALL_CLIMB =
            ABILITIES.register("wall_climb", WallClimbAbility::new);

    public static final Supplier<TendrilsAbility> TENDRILS =
            ABILITIES.register("tendrils", TendrilsAbility::new);

    public static final Supplier<BlackoutAbility> BLACKOUT =
            ABILITIES.register("blackout", BlackoutAbility::new);

    public static final Supplier<DisruptionAbility> DISRUPTION =
            ABILITIES.register("disruption", DisruptionAbility::new);

    public static final Supplier<BloxShieldAbility> BLOX_SHIELD =
            ABILITIES.register("blox_shield", BloxShieldAbility::new);

    public static final Supplier<BloxDashAbility> BLOX_DASH =
            ABILITIES.register("blox_dash", BloxDashAbility::new);

    public static final Supplier<BloxSpeedAbility> BLOX_SPEED =
            ABILITIES.register("blox_speed", BloxSpeedAbility::new);

    public static final Supplier<PhotosynthesisAbility> PHOTOSYNTHESIS =
            ABILITIES.register("photosynthesis", PhotosynthesisAbility::new);

    public static final Supplier<NatureGiftAbility> NATURES_GIFT =
            ABILITIES.register("nature_gift", NatureGiftAbility::new);

    public static final Supplier<NatureSightAbility> NATURES_SIGHT =
            ABILITIES.register("nature_sight", NatureSightAbility::new);

    public static final Supplier<GrowthDebuff> GROWTH_DEBUFF =
            ABILITIES.register("growth_debuff", GrowthDebuff::new);

    public static final Supplier<HeartbeatAbility> HEARTBEAT =
            ABILITIES.register("heartbeat", HeartbeatAbility::new);

    public static final Supplier<SolarSurgeAbility> SOLAR_SURGE =
            ABILITIES.register("solar_surge", SolarSurgeAbility::new);

    public static final Supplier<UltrakillDashAbility> ULTRAKILL_DASH =
            ABILITIES.register("ultrakill_dash", UltrakillDashAbility::new);

    public static final Supplier<UltrakillSlamAbility> ULTRAKILL_SLAM =
            ABILITIES.register("ultrakill_slam", UltrakillSlamAbility::new);

    public static final Supplier<UltrakillFeedbackerAbility> ULTRAKILL_FEEDBACKER =
            ABILITIES.register("ultrakill_feedbacker", UltrakillFeedbackerAbility::new);

    public static final Supplier<EndStepAbility> END_STEP =
            ABILITIES.register("end_step", EndStepAbility::new);
    public static final Supplier<SkulkBlastAbility> SKULK_BLAST =
            ABILITIES.register("skulk_blast", SkulkBlastAbility::new);

    public static final Supplier<WardenSkinAbility> WARDEN_SKIN =
            ABILITIES.register("warden_skin", WardenSkinAbility::new);

    public static final Supplier<WardenStrengthAbility> WARDEN_STRENGTH =
            ABILITIES.register("warden_strength", WardenStrengthAbility::new);

    public static final Supplier<SonicBoomAbility> SONIC_BOOM =
            ABILITIES.register("sonic_boom", SonicBoomAbility::new);

    public static final Supplier<StrongLegsHeavyArmsAbility> STRONG_LEGS_HEAVY_ARMS =
            ABILITIES.register("strong_legs_heavy_arms", StrongLegsHeavyArmsAbility::new);

    /*public static final Supplier<SkulkShieldAbility> SKULK_SHIELD =
            ABILITIES.register("skulk_shield", SkulkShieldAbility::new);*/
    //Unimplemented ability commented out for now

    public static final Supplier<DeepDarknessAbility> DEEP_DARKNESS =
            ABILITIES.register("deep_darkness", DeepDarknessAbility::new);

    public static final Supplier<AidFromBelowAbility> AID_FROM_BELOW =
            ABILITIES.register("aid_from_below", AidFromBelowAbility::new);

    public static final Supplier<OneWithTheDark> ONE_WITH_THE_DARK =
            ABILITIES.register("one_with_the_dark", OneWithTheDark::new);

    public static final Supplier<FireballAbility> FIREBALL =
            ABILITIES.register("fireball", FireballAbility::new);

    public static final Supplier<ArrowAbility> ARROW =
            ABILITIES.register("arrow", ArrowAbility::new);

    public static final Supplier<SummonBigHandsAbility> SUMMON_BIG_HANDS =
            ABILITIES.register("summon_big_hands", SummonBigHandsAbility::new);

    public static final Supplier<EmberFlight> EMBER_FLIGHT =
            ABILITIES.register("flight", EmberFlight::new);

    public static final Supplier<EmberFlightBoost> FLIGHT_BOOST =
            ABILITIES.register("flight_boost", EmberFlightBoost::new);

    public static final Supplier<EmberSustainedFlight> SUSTAINED_FLIGHT =
            ABILITIES.register("sustained_flight", EmberSustainedFlight::new);

    public static final Supplier<EmberBirdSong> BIRD_SONG =
            ABILITIES.register("bird_song", EmberBirdSong::new);

    public static final Supplier<EmberJumpBoost> JUMP_BOOST =
            ABILITIES.register("jump_boost", EmberJumpBoost::new);

    public static final Supplier<HarkenTrueSight> TRUE_SIGHT =
            ABILITIES.register("true_sight", HarkenTrueSight::new);

    public static final Supplier<HarkenerSilentDash> SILENT_DASH =
            ABILITIES.register("silent_dash", HarkenerSilentDash::new);

    public static final Supplier<HarkenerWrathfulAdvance> WRATHFUL_ADVANCE =
            ABILITIES.register("wrathful_advance", HarkenerWrathfulAdvance::new);

    public static final Supplier<AmplifyAbility> AMPLIFY =
            ABILITIES.register("amplify", AmplifyAbility::new);

    public static final Supplier<ReverseAbility> REVERSE =
            ABILITIES.register("reverse", ReverseAbility::new);

    public static final Supplier<AriyhomeAbility> HOME =
            ABILITIES.register("home_coming", AriyhomeAbility::new);

    public static final Supplier<WaterjumpAbility> WJUMP =
            ABILITIES.register("water_jump", WaterjumpAbility::new);

    public static final Supplier<GroundpunchAbility> GPUNCH =
            ABILITIES.register("ground_punch", GroundpunchAbility::new);

    public static final Supplier<StrengthrandAbility> SROLL =
            ABILITIES.register("strength_random", StrengthrandAbility::new);


    public static void register(IEventBus eventBus) { ABILITIES.register(eventBus); }

}
