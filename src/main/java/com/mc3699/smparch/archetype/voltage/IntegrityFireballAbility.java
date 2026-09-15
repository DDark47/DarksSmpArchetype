package com.mc3699.smparch.archetype.voltage;

import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.integrity.phase3.IntegFireballEntity;
import net.thebrokenscript.registry.TBSEntities;

public class IntegrityFireballAbility extends BaseAbility {
    
    
    @Override
    public int getCooldown() {
        return 1*20;
    }
    
    @Override
    public float getUseCost() {
        return 0f;
    }
    
    @Override
    public Component getName() {
        return Component.literal("Integrity Fireball").withStyle(ChatFormatting.RED);
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        ServerLevel serverLevel = player.serverLevel();
        Vec3 lookVec = player.getLookAngle();
        Vec3 spawnPos = player.getEyePosition().add(lookVec.scale(1.0f));
        Vec3 velocity = lookVec.scale(1.5f);
        
        IntegFireballEntity fireball = new IntegFireballEntity(
            TBSEntities.INTEG_FIREBALL.get(),
            serverLevel
        );
        fireball.setPos(spawnPos);
        fireball.setDeltaMovement(velocity);
        
        serverLevel.addFreshEntity(fireball);
        serverLevel.playSound(null, player.getBlockPosBelowThatAffectsMyMovement().above(1), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1, 1);
    }
    
    @Override
    public boolean canExecute(ServerPlayer serverPlayer) {
        return true;
    }
    
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("thebrokenscript", "textures/item/integrity_fireball.png");
    }
}
