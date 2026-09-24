package com.mc3699.smparch.archetype.voltage;

import com.mc3699.smparch.SMPArch;
import net.mc3699.provenance.ProvenanceDataHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.thebrokenscript.brokencore.impl.registry.BCSoundCategories;
import net.thebrokenscript.registry.TBSSounds;

@EventBusSubscriber(modid = SMPArch.MODID)
public class EventHandlers {
    @SubscribeEvent
    public static void endChase(LivingDeathEvent event) {
        if (event.getSource().getDirectEntity() instanceof ServerPlayer player) {
            if (ProvenanceDataHandler.getAbilities(player).stream().anyMatch(ability -> ability instanceof VoltageChaseAbility)
                    && !VoltageChaseAbility.CHASED_PLAYERS.isEmpty()) {
                ServerLevel level = player.serverLevel();
                level.playSound(null, player.blockPosition(), TBSSounds.THE_END_IS_NEAR.invoke(), BCSoundCategories.BC_CHASE, 1000F, 0.6F);
                VoltageChaseAbility.INSTANCE.chaseEnd(true);
                player.setGameMode(GameType.SPECTATOR);
            }
            if (ProvenanceDataHandler.getAbilities(player).stream().anyMatch(ability -> ability instanceof CircuitChaseAbility)
                    && CircuitChaseAbility.INSTANCE.summonedCircuit != null) {
                player.setGameMode(GameType.SPECTATOR);
            }
        }
        
        if (event.getEntity() instanceof ServerPlayer player) {
            if (ProvenanceDataHandler.getAbilities(player).stream().anyMatch(ability -> ability instanceof VoltageChaseAbility)
                    && !VoltageChaseAbility.CHASED_PLAYERS.isEmpty()) {
                VoltageChaseAbility.INSTANCE.chaseEnd(true);
                player.setGameMode(GameType.SPECTATOR);
            }
            if (ProvenanceDataHandler.getAbilities(player).stream().anyMatch(ability -> ability instanceof CircuitChaseAbility)
                    && CircuitChaseAbility.INSTANCE.summonedCircuit != null) {
                player.setGameMode(GameType.SPECTATOR);
            }
        }
    }
    
    @SubscribeEvent
    public static void dropVoidTendrils(LivingDeathEvent event) {
        if (ModList.get().isLoaded("thebrokenlegacy")
                && event.getEntity() instanceof ServerPlayer player
                && ProvenanceDataHandler.getAmbientAbilities(player).stream().anyMatch(ability -> ability instanceof VoidEntityAmbient)) {
            
            ItemStack item = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("thebrokenlegacy", "void_tendrils")), player.getRandom().nextInt(1, 5));
            player.spawnAtLocation(item);
        }
    }
}
