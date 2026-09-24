package com.mc3699.smparch.archetype.voltage;

import kotlin.Unit;
import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.registry.TBSSounds;

public class VoltageJumpscareAbility extends BaseAbility {
    @Override
    public float getUseCost() {
        return 0;
    }
    
    @Override
    public int getCooldown() {
        return 0;
    }
    
    @Override
    public Component getName() {
        return Component.literal("Voltage Jumpscare");
    }
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("thebrokenscript","textures/particle/particle_of_curved.png");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        ServerLevel level = player.serverLevel();
        player.setGameMode(GameType.SURVIVAL);
        ServerPlayer target = level.getNearestEntity(ServerPlayer.class, TargetingConditions.forNonCombat().ignoreInvisibilityTesting().ignoreLineOfSight(), player, player.getX(), player.getY(), player.getZ(), player.getBoundingBox().inflate(6));
        if (target == null) return;
        
        player.setNoGravity(true);
        player.setDeltaMovement(0,0,0);
        player.lookAt(EntityAnchorArgument.Anchor.EYES, target, EntityAnchorArgument.Anchor.EYES);
        target.lookAt(EntityAnchorArgument.Anchor.EYES, player, EntityAnchorArgument.Anchor.EYES);
        level.playSound(null, player.blockPosition(), TBSSounds.CIRCUIT_JUMPSCARE.invoke(), SoundSource.PLAYERS);
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 255, true, false, true));
        target.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 9, true, false, true));

        TheBrokenScript.serverWorkQueue.add(15L, () -> {
            player.setNoGravity(false);
            player.setGameMode(GameType.SPECTATOR);
            return Unit.INSTANCE;
        });
        
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return true;
    }
    
}
