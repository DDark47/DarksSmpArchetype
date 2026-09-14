package com.mc3699.smparch.registry;

import com.mc3699.smparch.SMPArch;
import com.mc3699.smparch.archetype.aidenman.AidenArchetype;
import com.mc3699.smparch.archetype.ariytwo6.AriytwoArchetype;
import com.mc3699.smparch.archetype.arveral.ArveralArchetype;
import com.mc3699.smparch.archetype.blox.BloxArchetype;
import com.mc3699.smparch.archetype.emberflame65.EmberFlameArchetype;
import com.mc3699.smparch.archetype.eyae.EyaeArchetype;
import com.mc3699.smparch.archetype.firelight.FirelightArchetype;
import com.mc3699.smparch.archetype.growth.GrowthArchetype;
import com.mc3699.smparch.archetype.heaven.HeavenArchetype;
import com.mc3699.smparch.archetype.john_generic.JohnArchetype;
import com.mc3699.smparch.archetype.john_ultrakill.JohnUltrakillArchetype;
import com.mc3699.smparch.archetype.miku.MikuArchetype;
import com.mc3699.smparch.archetype.nightheart.NightheartArchetype;
import com.mc3699.smparch.archetype.pencil_html.PencilHtmlArchetype;
import com.mc3699.smparch.archetype.teebee.TeebeeArchetype;
import com.mc3699.smparch.archetype.tekkitdooood.TekkitdoooodArchetype;
import com.mc3699.smparch.archetype.terra.TerraArchetype;
import com.mc3699.smparch.archetype.zorgoliath.HarkenerArchetype;
import net.mc3699.provenance.ProvenanceRegistries;
import net.mc3699.provenance.archetype.foundation.BaseArchetype;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SMPArchetypes {

    public static final DeferredRegister<BaseArchetype> ARCHETYPES =
            DeferredRegister.create(ProvenanceRegistries.ARCHETYPE_REGISTRY, SMPArch.MODID);


    public static final Supplier<NightheartArchetype> NIGHTHEART =
            ARCHETYPES.register("nightheart", NightheartArchetype::new);

    public static final Supplier<FirelightArchetype> FIRELIGHT =
            ARCHETYPES.register("firelight", FirelightArchetype::new);

    public static final Supplier<ArveralArchetype> ARVERAL =
            ARCHETYPES.register("arveral", ArveralArchetype::new);

    public static final Supplier<BloxArchetype> BLOX =
            ARCHETYPES.register("blox", BloxArchetype::new);

    public static final Supplier<HeavenArchetype> HEAVEN =
            ARCHETYPES.register("heaven", HeavenArchetype::new);

    public static final Supplier<AidenArchetype> AIDEN =
            ARCHETYPES.register("aiden", AidenArchetype::new);

    public static final Supplier<GrowthArchetype> GROWTH =
            ARCHETYPES.register("growth", GrowthArchetype::new);

    public static final Supplier<TerraArchetype> TERRA =
            ARCHETYPES.register("terra", TerraArchetype::new);

    public static final Supplier<JohnUltrakillArchetype> JOHN_ULTRAKILL =
            ARCHETYPES.register("john_ultrakill", JohnUltrakillArchetype::new);

    public static final Supplier<PencilHtmlArchetype> PENCIL_HTML =
            ARCHETYPES.register("pencil_html", PencilHtmlArchetype::new);

    public static final Supplier<TekkitdoooodArchetype> TEKKITDOOOOD =
            ARCHETYPES.register("tekkitdooood", TekkitdoooodArchetype::new);

    public static final Supplier<MikuArchetype> MIKU =
            ARCHETYPES.register("miku", MikuArchetype::new);

    public static final Supplier<EyaeArchetype> EYAE =
            ARCHETYPES.register("eyae", EyaeArchetype::new);

    public static final Supplier<JohnArchetype> JOHN_GENERIC =
            ARCHETYPES.register("john_generic", JohnArchetype::new);

    public static final Supplier<EmberFlameArchetype> EMBER_FLAME =
            ARCHETYPES.register("ember_flame", EmberFlameArchetype::new);

    public static final Supplier<HarkenerArchetype> HARKENER =
            ARCHETYPES.register("harkener", HarkenerArchetype::new);

    public static final Supplier<TeebeeArchetype> TEEBEE =
            ARCHETYPES.register("teebee", TeebeeArchetype::new);

    public static final Supplier<AriytwoArchetype> ARIYTWO =
            ARCHETYPES.register("ariytwo6", AriytwoArchetype::new);

    public static void register(IEventBus eventBus)
    {
        ARCHETYPES.register(eventBus);
    }
}
