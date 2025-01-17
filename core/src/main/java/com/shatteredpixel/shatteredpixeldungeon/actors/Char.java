/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.actors;

import static com.shatteredpixel.shatteredpixeldungeon.Dungeon.gold;
import static com.shatteredpixel.shatteredpixeldungeon.Dungeon.hero;
import static com.shatteredpixel.shatteredpixeldungeon.Dungeon.level;
import static com.shatteredpixel.shatteredpixeldungeon.items.Item.updateQuickslot;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Challenges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Electricity;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.ToxicGas;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Adrenaline;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.AllyBuff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Amok;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ArcaneArmor;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barkskin;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Berserk;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bleeding;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bless;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Burning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ChampionEnemy;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Charm;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Chill;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Corrosion;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Corruption;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Cripple;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Demonization;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Doom;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ExtraBullet;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Dread;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.FireImbue;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Flurry;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Frost;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.FrostImbue;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Fury;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Haste;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hex;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.LanceBuff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.LanceGuard;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.LifeLink;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Light;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.LostInventory;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MagicalSleep;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Momentum;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Ooze;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Outlaw;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Paralysis;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Preparation;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.PrismaticGuard;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.SerialAttack;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ShieldBuff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Slow;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.SnipersMark;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.SpearGuard;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Speed;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Stamina;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Swing;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Terror;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vertigo;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vulnerable;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Weakness;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroClass;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.gunner.ReinforcedArmor;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.gunner.Riot;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.nurse.AngelWing;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.planter.TreasureMap;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.rogue.DeathMark;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.samurai.Awake;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.samurai.ShadowBlade;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.warrior.Endure;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Elemental;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.PrismaticImage;
import com.shatteredpixel.shatteredpixeldungeon.effects.Lightning;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.effects.SpellSprite;
import com.shatteredpixel.shatteredpixeldungeon.effects.Splash;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.FlameParticle;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.ShadowParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.glyphs.AntiMagic;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.glyphs.Potential;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CloakOfShadows;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.DriedRose;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.TalismanOfForesight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfElements;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfRush;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRecharging;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRetribution;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPsionicBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfBlastWave;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfFireblast;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfLightning;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.Blazing;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.Blocking;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.Blooming;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.Grim;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.Shocking;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.*;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Cross;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.ShockingDart;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.Chasm;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.Door;
import com.shatteredpixel.shatteredpixeldungeon.levels.traps.GrimTrap;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.Earthroot;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.BArray;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundlable;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public abstract class Char extends Actor {
	
	public int pos = 0;
	
	public CharSprite sprite;
	
	public int HT;
	public int HP;
	
	protected float baseSpeed	= 1;
	protected PathFinder.Path path;

	public int paralysed	    = 0;
	public boolean rooted		= false;
	public boolean flying		= false;
	public int invisible		= 0;
	
	//these are relative to the hero
	public enum Alignment{
		ENEMY,
		NEUTRAL,
		ALLY
	}
	public Alignment alignment;
	
	public int viewDistance	= 8;
	
	public boolean[] fieldOfView = null;
	
	private HashSet<Buff> buffs = new HashSet<>();
	
	@Override
	protected boolean act() {
		if (fieldOfView == null || fieldOfView.length != Dungeon.level.length()){
			fieldOfView = new boolean[Dungeon.level.length()];
		}
		Dungeon.level.updateFieldOfView( this, fieldOfView );

		//throw any items that are on top of an immovable char
		if (properties().contains(Property.IMMOVABLE)){
			throwItems();
		}
		return false;
	}

	protected void throwItems(){
		Heap heap = Dungeon.level.heaps.get( pos );
		if (heap != null && heap.type == Heap.Type.HEAP) {
			int n;
			do {
				n = pos + PathFinder.NEIGHBOURS8[Random.Int( 8 )];
			} while (!Dungeon.level.passable[n] && !Dungeon.level.avoid[n]);
			Dungeon.level.drop( heap.pickUp(), n ).sprite.drop( pos );
		}
	}

	public String name(){
		return Messages.get(this, "name");
	}

	public boolean canInteract(Char c){
		if (Dungeon.level.adjacent( pos, c.pos )){
			return true;
		} else if (c instanceof Hero
				&& alignment == Alignment.ALLY
				&& Dungeon.level.distance(pos, c.pos) <= 2*Dungeon.hero.pointsInTalent(Talent.ALLY_WARP)){
			return true;
		} else {
			return false;
		}
	}
	
	//swaps places by default
	public boolean interact(Char c){

		//don't allow char to swap onto hazard unless they're flying
		//you can swap onto a hazard though, as you're not the one instigating the swap
		if (!Dungeon.level.passable[pos] && !c.flying){
			return true;
		}

		//can't swap into a space without room
		if (properties().contains(Property.LARGE) && !Dungeon.level.openSpace[c.pos]
			|| c.properties().contains(Property.LARGE) && !Dungeon.level.openSpace[pos]){
			return true;
		}

		int curPos = pos;

		//warp instantly with allies in this case
		if (c == Dungeon.hero && Dungeon.hero.hasTalent(Talent.ALLY_WARP)){
			PathFinder.buildDistanceMap(c.pos, BArray.or(Dungeon.level.passable, Dungeon.level.avoid, null));
			if (PathFinder.distance[pos] == Integer.MAX_VALUE){
				return true;
			}
			ScrollOfTeleportation.appear(this, c.pos);
			ScrollOfTeleportation.appear(c, curPos);
			Dungeon.observe();
			GameScene.updateFog();
			return true;
		}

		//can't swap places if one char has restricted movement
		if (rooted || c.rooted || buff(Vertigo.class) != null || c.buff(Vertigo.class) != null){
			return true;
		}

		moveSprite( pos, c.pos );
		move( c.pos );
		
		c.sprite.move( c.pos, curPos );
		c.move( curPos );
		
		c.spend( 1 / c.speed() );

		if (c == Dungeon.hero){
			if (Dungeon.hero.subClass == HeroSubClass.FREERUNNER){
				Buff.affect(Dungeon.hero, Momentum.class).gainStack();
			}

			Dungeon.hero.busy();
		}

		if (c == Dungeon.hero){
			if (Dungeon.hero.subClass == HeroSubClass.RANGER && Random.Int(50) == 0){
				Buff.affect(Dungeon.hero, Haste.class,5);
			}

			Dungeon.hero.busy();
		}

		if (c == hero && hero.subClass == HeroSubClass.RANGER && Random.Int(100) < hero.pointsInTalent(Talent.QUICK_RELOAD)*hero.speed()) {
			if (hero.belongings.weapon() instanceof CrudePistol && ((CrudePistol)hero.belongings.weapon).round < ((CrudePistol)hero.belongings.weapon).max_round) {

				((CrudePistol)hero.belongings.weapon).round = Math.min(((CrudePistol)hero.belongings.weapon).round+1, ((CrudePistol)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof CrudePistolAP && ((CrudePistolAP)hero.belongings.weapon).round < ((CrudePistolAP)hero.belongings.weapon).max_round) {

				((CrudePistolAP)hero.belongings.weapon).round = Math.min(((CrudePistolAP)hero.belongings.weapon).round+1, ((CrudePistolAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof CrudePistolHP && ((CrudePistolHP)hero.belongings.weapon).round < ((CrudePistolHP)hero.belongings.weapon).max_round) {

				((CrudePistolHP)hero.belongings.weapon).round = Math.min(((CrudePistolHP)hero.belongings.weapon).round+1, ((CrudePistolHP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof Pistol && ((Pistol)hero.belongings.weapon).round < ((Pistol)hero.belongings.weapon).max_round) {

				((Pistol)hero.belongings.weapon).round = Math.min(((Pistol)hero.belongings.weapon).round+1, ((Pistol)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof PistolAP && ((PistolAP)hero.belongings.weapon).round < ((PistolAP)hero.belongings.weapon).max_round) {

				((PistolAP)hero.belongings.weapon).round = Math.min(((PistolAP)hero.belongings.weapon).round+1, ((PistolAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof PistolHP && ((PistolHP)hero.belongings.weapon).round < ((PistolHP)hero.belongings.weapon).max_round) {

				((PistolHP)hero.belongings.weapon).round = Math.min(((PistolHP)hero.belongings.weapon).round+1, ((PistolHP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof GoldenPistol && ((GoldenPistol)hero.belongings.weapon).round < ((GoldenPistol)hero.belongings.weapon).max_round) {

				((GoldenPistol)hero.belongings.weapon).round = Math.min(((GoldenPistol)hero.belongings.weapon).round+1, ((GoldenPistol)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof GoldenPistolAP && ((GoldenPistolAP)hero.belongings.weapon).round < ((GoldenPistolAP)hero.belongings.weapon).max_round) {

				((GoldenPistolAP)hero.belongings.weapon).round = Math.min(((GoldenPistolAP)hero.belongings.weapon).round+1, ((GoldenPistolAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof GoldenPistolHP && ((GoldenPistolHP)hero.belongings.weapon).round < ((GoldenPistolHP)hero.belongings.weapon).max_round) {

				((GoldenPistolHP)hero.belongings.weapon).round = Math.min(((GoldenPistolHP)hero.belongings.weapon).round+1, ((GoldenPistolHP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof Handgun && ((Handgun)hero.belongings.weapon).round < ((Handgun)hero.belongings.weapon).max_round) {

				((Handgun)hero.belongings.weapon).round = Math.min(((Handgun)hero.belongings.weapon).round+1, ((Handgun)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof HandgunAP && ((HandgunAP)hero.belongings.weapon).round < ((HandgunAP)hero.belongings.weapon).max_round) {

				((HandgunAP)hero.belongings.weapon).round = Math.min(((HandgunAP)hero.belongings.weapon).round+1, ((HandgunAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof HandgunHP && ((HandgunHP)hero.belongings.weapon).round < ((HandgunHP)hero.belongings.weapon).max_round) {

				((HandgunHP)hero.belongings.weapon).round = Math.min(((HandgunHP)hero.belongings.weapon).round+1, ((HandgunHP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof Magnum && ((Magnum)hero.belongings.weapon).round < ((Magnum)hero.belongings.weapon).max_round) {

				((Magnum)hero.belongings.weapon).round = Math.min(((Magnum)hero.belongings.weapon).round+1, ((Magnum)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof MagnumAP && ((MagnumAP)hero.belongings.weapon).round < ((MagnumAP)hero.belongings.weapon).max_round) {

				((MagnumAP)hero.belongings.weapon).round = Math.min(((MagnumAP)hero.belongings.weapon).round+1, ((MagnumAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof MagnumHP && ((MagnumHP)hero.belongings.weapon).round < ((MagnumHP)hero.belongings.weapon).max_round) {

				((MagnumHP)hero.belongings.weapon).round = Math.min(((MagnumHP)hero.belongings.weapon).round+1, ((MagnumHP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof TacticalHandgun && ((TacticalHandgun)hero.belongings.weapon).round < ((TacticalHandgun)hero.belongings.weapon).max_round) {

				((TacticalHandgun)hero.belongings.weapon).round = Math.min(((TacticalHandgun)hero.belongings.weapon).round+1, ((TacticalHandgun)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof TacticalHandgunAP && ((TacticalHandgunAP)hero.belongings.weapon).round < ((TacticalHandgunAP)hero.belongings.weapon).max_round) {

				((TacticalHandgunAP)hero.belongings.weapon).round = Math.min(((TacticalHandgunAP)hero.belongings.weapon).round+1, ((TacticalHandgunAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof TacticalHandgunHP && ((TacticalHandgunHP)hero.belongings.weapon).round < ((TacticalHandgunHP)hero.belongings.weapon).max_round) {

				((TacticalHandgunHP)hero.belongings.weapon).round = Math.min(((TacticalHandgunHP)hero.belongings.weapon).round+1, ((TacticalHandgunHP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof DualPistol && ((DualPistol)hero.belongings.weapon).round < ((DualPistol)hero.belongings.weapon).max_round) {

				((DualPistol)hero.belongings.weapon).round = Math.min(((DualPistol)hero.belongings.weapon).round+1, ((DualPistol)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof DualPistolAP && ((DualPistolAP)hero.belongings.weapon).round < ((DualPistolAP)hero.belongings.weapon).max_round) {

				((DualPistolAP)hero.belongings.weapon).round = Math.min(((DualPistolAP)hero.belongings.weapon).round+1, ((DualPistolAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof DualPistolHP && ((DualPistolHP)hero.belongings.weapon).round < ((DualPistolHP)hero.belongings.weapon).max_round) {

				((DualPistolHP)hero.belongings.weapon).round = Math.min(((DualPistolHP)hero.belongings.weapon).round+1, ((DualPistolHP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof AutoHandgun && ((AutoHandgun)hero.belongings.weapon).round < ((AutoHandgun)hero.belongings.weapon).max_round) {

				((AutoHandgun)hero.belongings.weapon).round = Math.min(((AutoHandgun)hero.belongings.weapon).round+1, ((AutoHandgun)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof AutoHandgunAP && ((AutoHandgunAP)hero.belongings.weapon).round < ((AutoHandgunAP)hero.belongings.weapon).max_round) {

				((AutoHandgunAP)hero.belongings.weapon).round = Math.min(((AutoHandgunAP)hero.belongings.weapon).round+1, ((AutoHandgunAP)hero.belongings.weapon).max_round);

			} else if (hero.belongings.weapon() instanceof AutoHandgunHP && ((AutoHandgunHP)hero.belongings.weapon).round < ((AutoHandgunHP)hero.belongings.weapon).max_round) {

				((AutoHandgunHP)hero.belongings.weapon).round = Math.min(((AutoHandgunHP)hero.belongings.weapon).round+1, ((AutoHandgunHP)hero.belongings.weapon).max_round);

			}
			updateQuickslot();
		}

		if (c == Dungeon.hero){
			if (hero.subClass == HeroSubClass.SLAYER && hero.buff(Demonization.class) == null) {
				Buff.affect(hero, Demonization.class).indicate();
			}

			Dungeon.hero.busy();
		}

		
		return true;
	}
	
	protected boolean moveSprite( int from, int to ) {
		
		if (sprite.isVisible() && (Dungeon.level.heroFOV[from] || Dungeon.level.heroFOV[to])) {
			sprite.move( from, to );
			return true;
		} else {
			sprite.turnTo(from, to);
			sprite.place( to );
			return true;
		}
	}

	public void hitSound( float pitch ){
		Sample.INSTANCE.play(Assets.Sounds.HIT, 1, pitch);
	}

	public boolean blockSound( float pitch ) {
		return false;
	}
	
	protected static final String POS       = "pos";
	protected static final String TAG_HP    = "HP";
	protected static final String TAG_HT    = "HT";
	protected static final String TAG_SHLD  = "SHLD";
	protected static final String BUFFS	    = "buffs";
	
	@Override
	public void storeInBundle( Bundle bundle ) {
		
		super.storeInBundle( bundle );
		
		bundle.put( POS, pos );
		bundle.put( TAG_HP, HP );
		bundle.put( TAG_HT, HT );
		bundle.put( BUFFS, buffs );
	}
	
	@Override
	public void restoreFromBundle( Bundle bundle ) {
		
		super.restoreFromBundle( bundle );
		
		pos = bundle.getInt( POS );
		HP = bundle.getInt( TAG_HP );
		HT = bundle.getInt( TAG_HT );
		
		for (Bundlable b : bundle.getCollection( BUFFS )) {
			if (b != null) {
				((Buff)b).attachTo( this );
			}
		}
	}

	final public boolean attack( Char enemy ){
		if (hero.buff(Awake.awakeTracker.class) != null) {
			return attack(enemy, 1.2f+0.2f*hero.pointsInTalent(Talent.AWAKE_LIMIT), 0f, 1f);
		} else
		return attack(enemy, 1f, 0f, 1f);
	}
	
	public boolean attack( Char enemy, float dmgMulti, float dmgBonus, float accMulti ) {

		if (enemy == null) return false;
		
		boolean visibleFight = Dungeon.level.heroFOV[pos] || Dungeon.level.heroFOV[enemy.pos];

		if (enemy.isInvulnerable(getClass())) {

			if (visibleFight) {
				enemy.sprite.showStatus( CharSprite.POSITIVE, Messages.get(this, "invulnerable") );

				Sample.INSTANCE.play(Assets.Sounds.HIT_PARRY, 1f, Random.Float(0.96f, 1.05f));
			}

			return false;

		} else if (hit( this, enemy, accMulti )) {
			
			int dr = enemy.drRoll();

			Barkskin bark = enemy.buff(Barkskin.class);
			if (bark != null)   dr += Random.NormalIntRange( 0 , bark.level() );

			Blocking.BlockBuff block = enemy.buff(Blocking.BlockBuff.class);
			if (block != null)  dr += block.blockingRoll();

			ReinforcedArmor.reinforcedArmorTracker rearmor = enemy.buff(ReinforcedArmor.reinforcedArmorTracker.class);
			if (rearmor != null)  dr += rearmor.blockingRoll();

			if (this instanceof Hero) {
				if ( hero.belongings.weapon() instanceof Spear
					|| hero.belongings.weapon() instanceof Glaive
					|| hero.belongings.weapon() instanceof Lance ) {
					dr *= 1 - 0.1f*(Math.min(hero.belongings.weapon.buffedLvl(), 10));
				}
			}

			if (this instanceof Hero && Dungeon.isChallenged(Challenges.PYRO)) {
				Buff.affect(enemy, Burning.class).reignite(enemy, 8f);
			}
			
			if (this instanceof Hero){
				Hero h = (Hero)this;
				if (h.belongings.weapon() instanceof MissileWeapon
						&& h.subClass == HeroSubClass.SNIPER
						&& !Dungeon.level.adjacent(h.pos, enemy.pos)){
					dr = 0;
				}
				if (hero.buff(ShadowBlade.shadowBladeTracker.class) != null && Random.Int(2) == 0) {
					if (hero.hasTalent(Talent.CRITICAL_SHADOW)) {
						dmgBonus += Random.NormalIntRange(0, 5*hero.pointsInTalent(Talent.CRITICAL_SHADOW));
					}
					if (hero.hasTalent(Talent.HERBAL_SHADOW)) {
						int healAmt = hero.pointsInTalent(Talent.HERBAL_SHADOW);
						healAmt = Math.min( healAmt, hero.HT - hero.HP );
						if (healAmt > 0 && hero.isAlive()) {
							hero.HP += healAmt;
							hero.sprite.emitter().start( Speck.factory( Speck.HEALING ), 0.4f, 1 );
							hero.sprite.showStatus( CharSprite.POSITIVE, Integer.toString( healAmt ) );
						}
					}
					dr = 0;
				}
				else if (h.belongings.weapon() instanceof CrudePistolAP.Bullet
						|| h.belongings.weapon() instanceof PistolAP.Bullet
						|| h.belongings.weapon() instanceof GoldenPistolAP.Bullet
						|| h.belongings.weapon() instanceof HandgunAP.Bullet
						|| h.belongings.weapon() instanceof MagnumAP.Bullet
						|| h.belongings.weapon() instanceof AutoHandgunAP.Bullet
						|| h.belongings.weapon() instanceof HuntingRifleAP.Bullet
						|| h.belongings.weapon() instanceof SniperRifleAP.Bullet
						|| h.belongings.weapon() instanceof MarksmanRifleAP.Bullet
						|| h.belongings.weapon() instanceof DualPistolAP.Bullet
						|| h.belongings.weapon() instanceof SubMachinegunAP.Bullet
						|| h.belongings.weapon() instanceof AssultRifleAP.Bullet
						|| h.belongings.weapon() instanceof HeavyMachinegunAP.Bullet
						|| h.belongings.weapon() instanceof AutoRifleAP.Bullet
						|| h.belongings.weapon() instanceof ShotGunAP.Bullet
						|| h.belongings.weapon() instanceof SPASAP.Bullet
						|| h.belongings.weapon() instanceof MiniGunAP.Bullet
						|| h.belongings.weapon() instanceof TacticalHandgunAP.Bullet
						|| h.belongings.weapon() instanceof AntimaterRifleAP.Bullet
				) {
					dr = 0;
				} else if (h.belongings.weapon() instanceof CrudePistolHP.Bullet
						|| h.belongings.weapon() instanceof PistolHP.Bullet
						|| h.belongings.weapon() instanceof GoldenPistolHP.Bullet
						|| h.belongings.weapon() instanceof HandgunHP.Bullet
						|| h.belongings.weapon() instanceof MagnumHP.Bullet
						|| h.belongings.weapon() instanceof AutoHandgunHP.Bullet
						|| h.belongings.weapon() instanceof HuntingRifleHP.Bullet
						|| h.belongings.weapon() instanceof SniperRifleHP.Bullet
						|| h.belongings.weapon() instanceof MarksmanRifleHP.Bullet
						|| h.belongings.weapon() instanceof DualPistolHP.Bullet
						|| h.belongings.weapon() instanceof SubMachinegunHP.Bullet
						|| h.belongings.weapon() instanceof AssultRifleHP.Bullet
						|| h.belongings.weapon() instanceof HeavyMachinegunHP.Bullet
						|| h.belongings.weapon() instanceof AutoRifleHP.Bullet
						|| h.belongings.weapon() instanceof MiniGunHP.Bullet
						|| h.belongings.weapon() instanceof TacticalHandgunHP.Bullet
						|| h.belongings.weapon() instanceof AntimaterRifleHP.Bullet
				) {
					dr *= 3;
				} else if (h.belongings.weapon instanceof ShotGunHP.Bullet
						|| h.belongings.weapon instanceof SPASHP.Bullet) {
					dr *= 2.5;
				} else if (h.belongings.weapon instanceof ShotGun.Bullet
						|| h.belongings.weapon instanceof SPAS.Bullet) {
					dr *= 1.5;
				}
			}
			
			int dmg;
			Preparation prep = buff(Preparation.class);
			if (prep != null){
				dmg = prep.damageRoll(this);
				if (this == Dungeon.hero && Dungeon.hero.hasTalent(Talent.BOUNTY_HUNTER)) {
					Buff.affect(Dungeon.hero, Talent.BountyHunterTracker.class, 0.0f);
				}
			} else {
				dmg = damageRoll();
			}

			dmg = Math.round(dmg*dmgMulti);

			Berserk berserk = buff(Berserk.class);
			if (berserk != null) dmg = berserk.damageFactor(dmg);

			if (this instanceof Hero) {
				dmg *= RingOfRush.damageMultiplier(hero);
			}

			if (Dungeon.isChallenged(Challenges.SUPERMAN) && this instanceof Hero) {
				dmg *= 3f;
			}

			if (this instanceof Hero && hero.subClass == HeroSubClass.WEAPONMASTER && hero.belongings.weapon != null) {
				if (Random.Int(100) < Math.min(hero.belongings.weapon.buffedLvl()+1, 10) && (hero.belongings.weapon() instanceof WornKatana
				 || hero.belongings.weapon() instanceof ShortKatana
				 || hero.belongings.weapon() instanceof Katana
				 || hero.belongings.weapon() instanceof LongKatana
				 || hero.belongings.weapon() instanceof LargeKatana
				 || hero.belongings.weapon() instanceof SharpKatana)) {
					dmg *= 2f;
					Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG);
					hero.sprite.showStatus( CharSprite.NEUTRAL, "!" );
				}
			}

			if (hero.hasTalent(Talent.WEAPON_AUGMENT) && hero.belongings.weapon != null) {
				if (hero.pointsInTalent(Talent.WEAPON_AUGMENT) == 1) dmg *= 0.01f*Random.NormalIntRange(90, 110); // 90%-110% damage
				if (hero.pointsInTalent(Talent.WEAPON_AUGMENT) == 2) dmg *= 0.01f*Random.NormalIntRange(75, 125); // 75%-125% damage
				if (hero.pointsInTalent(Talent.WEAPON_AUGMENT) == 3) dmg *= 0.01f*Random.NormalIntRange(50, 150); // 50%-150% damage
			}

			if (this instanceof Hero && hero.buff(Bless.class) != null && hero.subClass == HeroSubClass.CRUSADER) {
				int healAmt = Math.max(Math.round(0.2f*dmg), 1);
					hero.HP = Math.min(hero.HT, hero.HP+healAmt);
					sprite.emitter().burst( Speck.factory( Speck.HEALING ), 1 );
					hero.sprite.showStatus( CharSprite.POSITIVE, Integer.toString( healAmt ) );
			}

			if (this instanceof Hero && hero.belongings.weapon != null) {
				float procChance; //chance to be activated
				int lvl = hero.belongings.weapon.buffedLvl();
				if (hero.belongings.weapon instanceof SpellBook_Corrosion) {
					procChance = (lvl+1f)/(lvl+5f);
					if (Random.Float() < procChance) {
						Buff.affect(enemy, Ooze.class).set(3+lvl);
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Corruption) {
					int procBonus = 0; //used for adding chances to corrupt
					if (enemy.buff(Weakness.class) != null) {
						procBonus += 1;
					}
					if (enemy.buff(Vulnerable.class) != null) {
						procBonus += 1;
					}
					if (enemy.buff(Cripple.class) != null) {
						procBonus += 1;
					}
					if (enemy.buff(Blindness.class) != null) {
						procBonus += 1;
					}
					if (enemy.buff(Terror.class) != null) {
						procBonus += 1;
					}
					if (enemy.buff(Amok.class) != null) {
						procBonus += 2;
					}
					if (enemy.buff(Slow.class) != null) {
						procBonus += 2;
					}
					if (enemy.buff(Hex.class) != null) {
						procBonus += 2;
					}
					if (enemy.buff(Paralysis.class) != null) {
						procBonus += 2;
					}
					if (enemy.buff(com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Doom.class) != null) {
						procChance = 1; //100% chance when enemy has a Doom debuff
					} else {
						procChance = (lvl+5f+procBonus)/(lvl+25f);
					}
					if (dmg >= enemy.HP
							&& Random.Float() < procChance
							&& !enemy.isImmune(Corruption.class)
							&& enemy.buff(Corruption.class) == null
							&& enemy instanceof Mob
							&& enemy.isAlive()){
						Mob mob = (Mob) enemy;
						Corruption.corruptionHeal(mob);
						AllyBuff.affectAndLoot(mob, hero, Corruption.class);
						dmg = 0;
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Blast) {
					procChance = (lvl+1f)/(lvl+5f);
					if (Random.Float() < procChance) {
						Buff.affect(enemy, Paralysis.class, (lvl >= 10) ? 1f : 2f);
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Earth) {
					procChance = 1/4f; //fixed at 1/4 regardless of lvl
					if (Random.Float() < procChance) {
						Buff.affect(hero, Earthroot.Armor.class).level(5+lvl);
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Fire) {
					procChance = (lvl+1f)/(lvl+3f);
					if (Random.Float() < procChance) {
						if (enemy.buff(Burning.class) != null){
							Buff.affect(enemy, Burning.class).reignite(enemy, 8f);
							int burnDamage = Random.NormalIntRange( 1, 3 + Dungeon.depth/4 );
							enemy.damage( Math.round(burnDamage * 0.67f), this );
						} else {
							Buff.affect(enemy, Burning.class).reignite(enemy, 8f);
						}
						enemy.sprite.emitter().burst( FlameParticle.FACTORY, lvl + 1 );
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Frost) {
					procChance = (lvl+1f)/(lvl+4f);
					if (Random.Float() < procChance) {
						//adds 3 turns of chill per proc, with a cap of 6 turns
						float durationToAdd = 3f;
						Chill existing = enemy.buff(Chill.class);
						if (existing != null){
							durationToAdd = Math.min(durationToAdd, 6f-existing.cooldown());
						}

						Buff.affect( enemy, Chill.class, durationToAdd );
						Splash.at( enemy.sprite.center(), 0xFFB2D6FF, 5);
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Lightning) {
					ArrayList<Lightning.Arc> arcs = new ArrayList<>();
					ArrayList<Char> affected = new ArrayList<>();
					procChance = (lvl+1f)/(lvl+4f);
					if (Random.Float() < procChance) {
						affected.clear();
						arcs.clear();

						Shocking.arc(hero, enemy, 2, affected, arcs);

						affected.remove(enemy); //defender isn't hurt by lightning
						for (Char ch : affected) {
							if (ch.alignment != hero.alignment) {
								ch.damage(Math.round(dmg * 0.4f), this);
							}
						}

						hero.sprite.parent.addToFront( new Lightning( arcs, null ) );
						Sample.INSTANCE.play( Assets.Sounds.LIGHTNING );
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Warding) {
					procChance = (lvl+1f)/(lvl+3f);
					if (Random.Float() < procChance) {
						boolean found = false;
						for (Mob m : Dungeon.level.mobs.toArray(new Mob[0])){
							if (m instanceof PrismaticImage){ //if the prismatic image is existing in the floor
								found = true;
								if (m.HP < m.HT) {
									m.HP = Math.min(m.HP+dmg/2, m.HT); //heals the prismatic image
									m.sprite.emitter().burst(Speck.factory(Speck.HEALING), 4);
									m.sprite.showStatus( CharSprite.POSITIVE, Integer.toString( Math.min(dmg/2, m.HT-m.HP) ) );
								}
							}
						}

						if (!found) {
							if (hero.buff(PrismaticGuard.class) != null) {
								Buff.affect(hero, PrismaticGuard.class).extend( dmg/2 ); //heals the buff's hp
							} else {
								Buff.affect(hero, PrismaticGuard.class).set( dmg/2 ); //affects a new buff to hero
							}
						}
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Regrowth) {
					procChance = (lvl+1f)/(lvl+3f);
					if (Random.Float() < procChance) {
						boolean secondPlant = Random.Int(3) == 0;
						ArrayList<Integer> positions = new ArrayList<>();
						Blooming blooming = new Blooming();
						for (int i : PathFinder.NEIGHBOURS8) {
							positions.add(i);
						}
						Random.shuffle(positions);
						for (int i : positions) {
							if (blooming.plantGrass(enemy.pos + i)) {
								if (secondPlant) secondPlant = false;
								else break;
							}
						}
					}
				} else if (hero.belongings.weapon instanceof SpellBook_Transfusion) {
					//chance to heal scales from 5%-30% based on missing HP
					float missingPercent = (hero.HT - hero.HP) / (float)hero.HT;
					procChance = 0.05f + 0.25f*missingPercent;
					if (Random.Float() < procChance) {

						//heals for 50% of damage dealt
						int healAmt = Math.round(dmg * 0.5f);
						healAmt = Math.min( healAmt, hero.HT - hero.HP );

						if (healAmt > 0 && hero.isAlive()) {

							hero.HP += healAmt;
							hero.sprite.emitter().start( Speck.factory( Speck.HEALING ), 0.4f, 1 );
							hero.sprite.showStatus( CharSprite.POSITIVE, Integer.toString( healAmt ) );

						}

					}
				} else if (hero.belongings.weapon instanceof SpellBook_Prismatic) {
					procChance = (lvl+1f)/(lvl+3f);
					if (Random.Float() < procChance) {
						Buff.affect(enemy, Blindness.class, 2+lvl);
					}
					if (enemy.properties().contains(Char.Property.DEMONIC) || enemy.properties().contains(Char.Property.UNDEAD)){
						enemy.sprite.emitter().start( ShadowParticle.UP, 0.05f, 10+lvl );
						Sample.INSTANCE.play(Assets.Sounds.BURNING);

						dmg *= 1.3333f; //deals more damage to the demons and the undeads
					}
				}
			}

			if (this instanceof Hero && hero.hasTalent(Talent.NAME_OF_LIGHT) && hero.buff(Bless.class) != null) {
				if (enemy.properties().contains(Char.Property.DEMONIC) || enemy.properties().contains(Char.Property.UNDEAD)) {
					enemy.sprite.emitter().start( ShadowParticle.UP, 0.05f, 10 );
					Sample.INSTANCE.play(Assets.Sounds.BURNING);

					dmg *= 1 + hero.pointsInTalent(Talent.NAME_OF_LIGHT)/3f; //deals more damage to the demons and the undeads
				}
			}

			if (this instanceof Hero && hero.belongings.weapon instanceof Cross) {
				if (enemy.properties().contains(Char.Property.DEMONIC) || enemy.properties().contains(Char.Property.UNDEAD)){
					enemy.sprite.emitter().start( ShadowParticle.UP, 0.05f, 10 );
					Sample.INSTANCE.play(Assets.Sounds.BURNING);

					dmg *= 1.3333f; //deals more damage to the demons and the undeads
				}
			}

			if (this instanceof Hero) {
				if (Dungeon.hero.belongings.weapon() instanceof AntimaterRifle.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifleAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifleHP.Bullet) {
					int distance = Dungeon.level.distance(hero.pos, enemy.pos) - 1;
					float multiplier = Math.min(3f, 1.2f * (float)Math.pow(1.125f, distance));
					dmg = Math.round(dmg * multiplier);
				}
			}

			if (this instanceof Hero && hero.belongings.weapon() instanceof ForceGlove) {
				if (Dungeon.level.adjacent( pos, enemy.pos )) {
					dmg *= 0.5f;
					//trace a ballistica to our target (which will also extend past them
					Ballistica trajectory = new Ballistica(pos, enemy.pos, Ballistica.STOP_TARGET);
					//trim it to just be the part that goes past them
					trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size()-1), Ballistica.PROJECTILE);
					//knock them back along that ballistica
					WandOfBlastWave.throwChar(enemy, trajectory, 20, true);
				}
			}

			if (this instanceof Hero && hero.buff(Swing.class) != null) {
				dmg += 2;
			}

			if (this instanceof Hero && Dungeon.level.map[hero.pos] == Terrain.WATER && Random.Int(10) < hero.pointsInTalent(Talent.WATER_FRIENDLY)) {
				dmg += 3;
				Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG);
			}

			if (this instanceof Hero && hero.buff(TreasureMap.GoldTracker.class) != null) {
				dmg *= 1 + 0.1f * hero.pointsInTalent(Talent.GOLD_HUNTER);
			}

			if (buff( Fury.class ) != null) {
				dmg *= 1.5f;
			}

			if (this instanceof Hero && hero.buff(LanceBuff.class) != null && hero.belongings.weapon() instanceof Lance) {
				dmg *= 1f + hero.buff(LanceBuff.class).getDamageFactor();
				Buff.detach(this, LanceBuff.class);
			}

			if (this instanceof Hero) {
				if (hero.buff(ShadowBlade.shadowBladeTracker.class) != null) {
					dmg *= 0.5f;
				}
			}

			if (this instanceof Hero && hero.hasTalent(Talent.VINE_WHIP) && hero.belongings.weapon instanceof MeleeWeapon) {
				dmg *= 1-0.2f*hero.pointsInTalent(Talent.VINE_WHIP);
			}

			if (this instanceof Hero && hero.belongings.weapon instanceof IronHammer && Random.Int(20) == 0) {
				Buff.affect(enemy, Paralysis.class, 1f);
			}

			if (this instanceof Hero && hero.belongings.weapon instanceof BeamSaber && Random.Int(40) == 0) {
				Buff.affect(enemy, Blindness.class, 2f);
			}

			if (this instanceof Hero
					&& hero.hasTalent(Talent.TAKEDOWN)
					&& hero.buff(Talent.TakeDownCooldown.class) == null
					&& (hero.belongings.weapon() instanceof Shovel || hero.belongings.weapon() instanceof Spade || hero.belongings.weapon() instanceof MinersTool)) {
				Buff.affect(hero, Talent.TakeDownCooldown.class, 20f);
			}

			if (this instanceof Hero) {
				if (hero.subClass == HeroSubClass.SLASHER) {
					if (hero.buff(SerialAttack.class) != null) {
						dmg *= 1f + 0.05f * hero.buff(SerialAttack.class).getCount();
						Buff.affect(hero, SerialAttack.class).hit(enemy);
					} else {
						dmg *= 1f;
						Buff.affect(hero, SerialAttack.class).hit(enemy);
					}
				}
			}

			if (this instanceof Hero) {
				if (dmg >= enemy.HP
						&& Random.Int(100) < 3*hero.pointsInTalent(Talent.DEADS_BLESS)
						&& hero.buff(Bless.class) != null
						&& !enemy.isImmune(AllyBuff.class)
						&& enemy.buff(AllyBuff.class) == null
						&& enemy instanceof Mob
						&& enemy.isAlive()){
					dmg = 0;
					int healAmt = enemy.HT-enemy.HP;
					enemy.HP += healAmt;
					enemy.sprite.emitter().burst( Speck.factory( Speck.HEALING ), 5 );
					AllyBuff.affectAndLoot((Mob)enemy, hero, ScrollOfSirensSong.Enthralled.class);
				}
			}

			if (this instanceof Hero) {
				if (Dungeon.hero.belongings.weapon() instanceof GrenadeLauncher.Rocket) {
					Buff.prolong(enemy, Vulnerable.class, 5f);
				}
				if (Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherHP.Rocket) {
					Buff.prolong(enemy, Paralysis.class, 3f);
				}
				//if (Dungeon.hero.belongings.weapon() instanceof SleepGun.Dart) {
				//	{actPriority = VFX_PRIO;}
				//	Buff.affect(enemy, MagicalSleep.class);
				//}
				//if (Dungeon.hero.belongings.weapon() instanceof FrostGun.Dart) {
				//	{actPriority = VFX_PRIO;}
				//	Buff.affect(enemy, Frost.class, 20f);
				//}
				//ParalysisGun paralysisGun = new ParalysisGun();
				//if (Dungeon.hero.belongings.weapon() instanceof ParalysisGun.Dart) {
				//	{actPriority = VFX_PRIO;}
				//	Buff.affect(enemy, Paralysis.class, 5f + paralysisGun.buffedLvl());
				//}
			}

			if (this instanceof Hero){
				Hero h = (Hero)this;
				if (h.belongings.weapon() instanceof CrudePistolAP.Bullet
				 || h.belongings.weapon() instanceof PistolAP.Bullet
				 || h.belongings.weapon() instanceof GoldenPistolAP.Bullet
				 || h.belongings.weapon() instanceof HandgunAP.Bullet
				 || h.belongings.weapon() instanceof MagnumAP.Bullet
				 || h.belongings.weapon() instanceof AutoHandgunAP.Bullet
				 || h.belongings.weapon() instanceof HuntingRifleAP.Bullet
				 || h.belongings.weapon() instanceof SniperRifleAP.Bullet
				 || h.belongings.weapon() instanceof DualPistolAP.Bullet
				 || h.belongings.weapon() instanceof SubMachinegunAP.Bullet
				 || h.belongings.weapon() instanceof AssultRifleAP.Bullet
				 || h.belongings.weapon() instanceof HeavyMachinegunAP.Bullet
				 || h.belongings.weapon() instanceof MiniGunAP.Bullet
				 || h.belongings.weapon() instanceof TacticalHandgunAP.Bullet
				 || h.belongings.weapon() instanceof AntimaterRifleAP.Bullet
				) {
					dmg *= 0.80f;
				} else if (h.belongings.weapon() instanceof CrudePistolHP.Bullet
					    || h.belongings.weapon() instanceof PistolHP.Bullet
					    || h.belongings.weapon() instanceof GoldenPistolHP.Bullet
					    || h.belongings.weapon() instanceof HandgunHP.Bullet
					    || h.belongings.weapon() instanceof MagnumHP.Bullet
					    || h.belongings.weapon() instanceof AutoHandgunHP.Bullet
					    || h.belongings.weapon() instanceof HuntingRifleHP.Bullet
					    || h.belongings.weapon() instanceof SniperRifleHP.Bullet
					    || h.belongings.weapon() instanceof DualPistolHP.Bullet
					    || h.belongings.weapon() instanceof SubMachinegunHP.Bullet
					    || h.belongings.weapon() instanceof AssultRifleHP.Bullet
					    || h.belongings.weapon() instanceof HeavyMachinegunHP.Bullet
						|| h.belongings.weapon() instanceof MiniGunHP.Bullet
						|| h.belongings.weapon() instanceof TacticalHandgunHP.Bullet
						|| h.belongings.weapon() instanceof AntimaterRifleHP.Bullet
				) {
					dmg *= 1.3f;
				}
			}

			if (this instanceof Hero) {
				Hero h = (Hero) this;
				if (h.belongings.weapon() instanceof DualPistol.Bullet
				 || h.belongings.weapon() instanceof DualPistolAP.Bullet
				 || h.belongings.weapon() instanceof DualPistolHP.Bullet
				 || h.belongings.weapon() instanceof SubMachinegun.Bullet
				 || h.belongings.weapon() instanceof SubMachinegunAP.Bullet
				 || h.belongings.weapon() instanceof SubMachinegunHP.Bullet
				 || h.belongings.weapon() instanceof AssultRifle.Bullet
				 || h.belongings.weapon() instanceof AssultRifleAP.Bullet
				 || h.belongings.weapon() instanceof AssultRifleHP.Bullet
				 || h.belongings.weapon() instanceof HeavyMachinegun.Bullet
				 || h.belongings.weapon() instanceof HeavyMachinegunAP.Bullet
				 || h.belongings.weapon() instanceof HeavyMachinegunHP.Bullet
				 || h.belongings.weapon() instanceof MiniGun.Bullet
				 || h.belongings.weapon() instanceof MiniGunAP.Bullet
				 || h.belongings.weapon() instanceof MiniGunHP.Bullet
				 || h.belongings.weapon() instanceof AutoRifle.Bullet
				 || h.belongings.weapon() instanceof AutoRifleAP.Bullet
				 || h.belongings.weapon() instanceof AutoRifleHP.Bullet
				) {
					dmg *= 1f - 0.1f*hero.pointsInTalent(Talent.DRUM_MAGAZINE);
				}
			}

			if (this instanceof Hero && hero.hasTalent(Talent.OUTLAW_OF_BARRENLAND)) {
				Hero h = (Hero) this;
				if ( hero.buff(Outlaw.class) != null && hero.buff(Outlaw.class).isReady() && (h.belongings.weapon() instanceof CrudePistol.Bullet
						|| h.belongings.weapon() instanceof CrudePistolAP.Bullet
						|| h.belongings.weapon() instanceof CrudePistolHP.Bullet
						|| h.belongings.weapon() instanceof Pistol.Bullet
						|| h.belongings.weapon() instanceof PistolAP.Bullet
						|| h.belongings.weapon() instanceof PistolHP.Bullet
						|| h.belongings.weapon() instanceof GoldenPistol.Bullet
						|| h.belongings.weapon() instanceof GoldenPistolAP.Bullet
						|| h.belongings.weapon() instanceof GoldenPistolHP.Bullet
						|| h.belongings.weapon() instanceof Magnum.Bullet
						|| h.belongings.weapon() instanceof MagnumAP.Bullet
						|| h.belongings.weapon() instanceof MagnumHP.Bullet
						|| h.belongings.weapon() instanceof TacticalHandgun.Bullet
						|| h.belongings.weapon() instanceof TacticalHandgunAP.Bullet
						|| h.belongings.weapon() instanceof TacticalHandgunHP.Bullet
						|| h.belongings.weapon() instanceof AutoHandgun.Bullet
						|| h.belongings.weapon() instanceof AutoHandgunAP.Bullet
						|| h.belongings.weapon() instanceof AutoHandgunHP.Bullet
						|| h.belongings.weapon() instanceof DualPistol.Bullet
						|| h.belongings.weapon() instanceof DualPistolAP.Bullet
						|| h.belongings.weapon() instanceof DualPistolHP.Bullet)) {
					dmg *= 2*hero.pointsInTalent(Talent.OUTLAW_OF_BARRENLAND);
					hero.buff(Outlaw.class).detach();
				}
			}

			if (this instanceof Hero) {
				if (hero.hasTalent(Talent.SURPRISE_BULLET) && ((Mob) enemy).surprisedBy(hero) && !level.adjacent(hero.pos, enemy.pos) && Random.Int(20) == 0) {
					if ((hero.belongings.weapon() instanceof HuntingRifle.Bullet
						|| hero.belongings.weapon() instanceof HuntingRifleAP.Bullet
						|| hero.belongings.weapon() instanceof HuntingRifleHP.Bullet
						|| hero.belongings.weapon() instanceof SniperRifle.Bullet
						|| hero.belongings.weapon() instanceof SniperRifleAP.Bullet
						|| hero.belongings.weapon() instanceof SniperRifleHP.Bullet
						|| hero.belongings.weapon() instanceof AntimaterRifle.Bullet
						|| hero.belongings.weapon() instanceof AntimaterRifleAP.Bullet
						|| hero.belongings.weapon() instanceof AntimaterRifleHP.Bullet
						|| hero.belongings.weapon() instanceof MarksmanRifle.Bullet
						|| hero.belongings.weapon() instanceof MarksmanRifleAP.Bullet
						|| hero.belongings.weapon() instanceof MarksmanRifleHP.Bullet)) {
						hero.sprite.showStatus( CharSprite.NEUTRAL, "!" );
						dmg *= 1+hero.pointsInTalent(Talent.SURPRISE_BULLET);
					}
				}
			}

			if (this instanceof Hero) {
				if ((hero.belongings.weapon() instanceof CrudePistol.Bullet && ((CrudePistol)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof CrudePistolAP.Bullet && ((CrudePistolAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof CrudePistolHP.Bullet && ((CrudePistolHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof Pistol.Bullet && ((Pistol)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof PistolAP.Bullet && ((PistolAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof PistolHP.Bullet && ((PistolHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof GoldenPistol.Bullet && ((GoldenPistol)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof GoldenPistolAP.Bullet && ((GoldenPistolAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof GoldenPistolHP.Bullet && ((GoldenPistolHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof Handgun.Bullet && ((Handgun)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HandgunAP.Bullet && ((HandgunAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HandgunHP.Bullet && ((HandgunHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof Magnum.Bullet && ((Magnum)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MagnumAP.Bullet && ((MagnumAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MagnumHP.Bullet && ((MagnumHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof TacticalHandgun.Bullet && ((TacticalHandgun)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof TacticalHandgunAP.Bullet && ((TacticalHandgunAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof TacticalHandgunHP.Bullet && ((TacticalHandgunHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AutoHandgun.Bullet && ((AutoHandgun)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AutoHandgunAP.Bullet && ((AutoHandgunAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AutoHandgunHP.Bullet && ((AutoHandgunHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof DualPistol.Bullet && ((DualPistol)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof DualPistolAP.Bullet && ((DualPistolAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof DualPistolHP.Bullet && ((DualPistolHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SubMachinegun.Bullet && ((SubMachinegun)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SubMachinegunAP.Bullet && ((SubMachinegunAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SubMachinegunHP.Bullet && ((SubMachinegunHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AssultRifle.Bullet && ((AssultRifle)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AssultRifleAP.Bullet && ((AssultRifleAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AssultRifleHP.Bullet && ((AssultRifleHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HeavyMachinegun.Bullet && ((HeavyMachinegun)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunAP.Bullet && ((HeavyMachinegunAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunHP.Bullet && ((HeavyMachinegunHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AutoRifle.Bullet && ((AutoRifle)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AutoRifleAP.Bullet && ((AutoRifleAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AutoRifleHP.Bullet && ((AutoRifleHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MiniGun.Bullet && ((MiniGun)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MiniGunAP.Bullet && ((MiniGunAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MiniGunHP.Bullet && ((MiniGunHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HuntingRifle.Bullet && ((HuntingRifle)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HuntingRifleAP.Bullet && ((HuntingRifleAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof HuntingRifleHP.Bullet && ((HuntingRifleHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SniperRifle.Bullet && ((SniperRifle)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SniperRifleAP.Bullet && ((SniperRifleAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SniperRifleHP.Bullet && ((SniperRifleHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AntimaterRifle.Bullet && ((AntimaterRifle)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AntimaterRifleAP.Bullet && ((AntimaterRifleAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof AntimaterRifleHP.Bullet && ((AntimaterRifleHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MarksmanRifle.Bullet && ((MarksmanRifle)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MarksmanRifleAP.Bullet && ((MarksmanRifleAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof MarksmanRifleHP.Bullet && ((MarksmanRifleHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof ShotGun.Bullet && ((ShotGun)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof ShotGunAP.Bullet && ((ShotGunAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof ShotGunHP.Bullet && ((ShotGunHP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SPAS.Bullet && ((SPAS)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SPASAP.Bullet && ((SPASAP)hero.belongings.weapon).silencer)
						|| (hero.belongings.weapon() instanceof SPASHP.Bullet && ((SPASHP)hero.belongings.weapon).silencer)
				) {
					dmg *= 0.75f;
				}

				if ((hero.belongings.weapon() instanceof CrudePistol && ((CrudePistol)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof CrudePistolAP && ((CrudePistolAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof CrudePistolHP && ((CrudePistolHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof Pistol && ((Pistol)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof PistolAP && ((PistolAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof PistolHP && ((PistolHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof GoldenPistol && ((GoldenPistol)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof GoldenPistolAP && ((GoldenPistolAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof GoldenPistolHP && ((GoldenPistolHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof Handgun && ((Handgun)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HandgunAP && ((HandgunAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HandgunHP && ((HandgunHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof Magnum && ((Magnum)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MagnumAP && ((MagnumAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MagnumHP && ((MagnumHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof TacticalHandgun && ((TacticalHandgun)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof TacticalHandgunAP && ((TacticalHandgunAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof TacticalHandgunHP && ((TacticalHandgunHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AutoHandgun && ((AutoHandgun)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AutoHandgunAP && ((AutoHandgunAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AutoHandgunHP && ((AutoHandgunHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof DualPistol && ((DualPistol)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof DualPistolAP && ((DualPistolAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof DualPistolHP && ((DualPistolHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SubMachinegun && ((SubMachinegun)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SubMachinegunAP && ((SubMachinegunAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SubMachinegunHP && ((SubMachinegunHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AssultRifle && ((AssultRifle)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AssultRifleAP && ((AssultRifleAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AssultRifleHP && ((AssultRifleHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HeavyMachinegun && ((HeavyMachinegun)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunAP && ((HeavyMachinegunAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunHP && ((HeavyMachinegunHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MiniGun && ((MiniGun)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MiniGunAP && ((MiniGunAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MiniGunHP && ((MiniGunHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AutoRifle && ((AutoRifle)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AutoRifleAP && ((AutoRifleAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AutoRifleHP && ((AutoRifleHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HuntingRifle && ((HuntingRifle)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HuntingRifleAP && ((HuntingRifleAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof HuntingRifleHP && ((HuntingRifleHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SniperRifle && ((SniperRifle)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SniperRifleAP && ((SniperRifleAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SniperRifleHP && ((SniperRifleHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AntimaterRifle && ((AntimaterRifle)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AntimaterRifleAP && ((AntimaterRifleAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof AntimaterRifleHP && ((AntimaterRifleHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MarksmanRifle && ((MarksmanRifle)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MarksmanRifleAP && ((MarksmanRifleAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof MarksmanRifleHP && ((MarksmanRifleHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof ShotGun && ((ShotGun)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof ShotGunAP && ((ShotGunAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof ShotGunHP && ((ShotGunHP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SPAS && ((SPAS)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SPASAP && ((SPASAP)hero.belongings.weapon).light)
						|| (hero.belongings.weapon() instanceof SPASHP && ((SPASHP)hero.belongings.weapon).light)
				) {
					dmg *= 0.75f;
				}

				if ((hero.belongings.weapon() instanceof CrudePistol && ((CrudePistol)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof CrudePistolAP && ((CrudePistolAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof CrudePistolHP && ((CrudePistolHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof Pistol && ((Pistol)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof PistolAP && ((PistolAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof PistolHP && ((PistolHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof GoldenPistol && ((GoldenPistol)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof GoldenPistolAP && ((GoldenPistolAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof GoldenPistolHP && ((GoldenPistolHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof Handgun && ((Handgun)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HandgunAP && ((HandgunAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HandgunHP && ((HandgunHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof Magnum && ((Magnum)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MagnumAP && ((MagnumAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MagnumHP && ((MagnumHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof TacticalHandgun && ((TacticalHandgun)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof TacticalHandgunAP && ((TacticalHandgunAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof TacticalHandgunHP && ((TacticalHandgunHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AutoHandgun && ((AutoHandgun)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AutoHandgunAP && ((AutoHandgunAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AutoHandgunHP && ((AutoHandgunHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof DualPistol && ((DualPistol)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof DualPistolAP && ((DualPistolAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof DualPistolHP && ((DualPistolHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SubMachinegun && ((SubMachinegun)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SubMachinegunAP && ((SubMachinegunAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SubMachinegunHP && ((SubMachinegunHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AssultRifle && ((AssultRifle)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AssultRifleAP && ((AssultRifleAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AssultRifleHP && ((AssultRifleHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HeavyMachinegun && ((HeavyMachinegun)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunAP && ((HeavyMachinegunAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunHP && ((HeavyMachinegunHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MiniGun && ((MiniGun)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MiniGunAP && ((MiniGunAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MiniGunHP && ((MiniGunHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AutoRifle && ((AutoRifle)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AutoRifleAP && ((AutoRifleAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AutoRifleHP && ((AutoRifleHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HuntingRifle && ((HuntingRifle)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HuntingRifleAP && ((HuntingRifleAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof HuntingRifleHP && ((HuntingRifleHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SniperRifle && ((SniperRifle)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SniperRifleAP && ((SniperRifleAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SniperRifleHP && ((SniperRifleHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AntimaterRifle && ((AntimaterRifle)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AntimaterRifleAP && ((AntimaterRifleAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof AntimaterRifleHP && ((AntimaterRifleHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MarksmanRifle && ((MarksmanRifle)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MarksmanRifleAP && ((MarksmanRifleAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof MarksmanRifleHP && ((MarksmanRifleHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof ShotGun && ((ShotGun)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof ShotGunAP && ((ShotGunAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof ShotGunHP && ((ShotGunHP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SPAS && ((SPAS)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SPASAP && ((SPASAP)hero.belongings.weapon).heavy)
						|| (hero.belongings.weapon() instanceof SPASHP && ((SPASHP)hero.belongings.weapon).heavy)
				) {
					dmg *= 1.1f;
				}

				if (((hero.belongings.weapon() instanceof CrudePistol.Bullet && ((CrudePistol)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof CrudePistolAP.Bullet && ((CrudePistolAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof CrudePistolHP.Bullet && ((CrudePistolHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof Pistol.Bullet && ((Pistol)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof PistolAP.Bullet && ((PistolAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof PistolHP.Bullet && ((PistolHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof GoldenPistol.Bullet && ((GoldenPistol)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof GoldenPistolAP.Bullet && ((GoldenPistolAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof GoldenPistolHP.Bullet && ((GoldenPistolHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof Handgun.Bullet && ((Handgun)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HandgunAP.Bullet && ((HandgunAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HandgunHP.Bullet && ((HandgunHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof Magnum.Bullet && ((Magnum)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof MagnumAP.Bullet && ((MagnumAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof MagnumHP.Bullet && ((MagnumHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof TacticalHandgun.Bullet && ((TacticalHandgun)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof TacticalHandgunAP.Bullet && ((TacticalHandgunAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof TacticalHandgunHP.Bullet && ((TacticalHandgunHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoHandgun.Bullet && ((AutoHandgun)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoHandgunAP.Bullet && ((AutoHandgunAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoHandgunHP.Bullet && ((AutoHandgunHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof DualPistol.Bullet && ((DualPistol)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof DualPistolAP.Bullet && ((DualPistolAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof DualPistolHP.Bullet && ((DualPistolHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SubMachinegun.Bullet && ((SubMachinegun)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SubMachinegunAP.Bullet && ((SubMachinegunAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SubMachinegunHP.Bullet && ((SubMachinegunHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AssultRifle.Bullet && ((AssultRifle)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AssultRifleAP.Bullet && ((AssultRifleAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AssultRifleHP.Bullet && ((AssultRifleHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HeavyMachinegun.Bullet && ((HeavyMachinegun)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunAP.Bullet && ((HeavyMachinegunAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HeavyMachinegunHP.Bullet && ((HeavyMachinegunHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof MiniGun.Bullet && ((MiniGun)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof MiniGunAP.Bullet && ((MiniGunAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof MiniGunHP.Bullet && ((MiniGunHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoRifle.Bullet && ((AutoRifle)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoRifleAP.Bullet && ((AutoRifleAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoRifleHP.Bullet && ((AutoRifleHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HuntingRifle.Bullet && ((HuntingRifle)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HuntingRifleAP.Bullet && ((HuntingRifleAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof HuntingRifleHP.Bullet && ((HuntingRifleHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SniperRifle.Bullet && ((SniperRifle)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SniperRifleAP.Bullet && ((SniperRifleAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SniperRifleHP.Bullet && ((SniperRifleHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AntimaterRifle.Bullet && ((AntimaterRifle)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AntimaterRifleAP.Bullet && ((AntimaterRifleAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AntimaterRifleHP.Bullet && ((AntimaterRifleHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoRifle.Bullet && ((AutoRifle)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoRifleAP.Bullet && ((AutoRifleAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof AutoRifleHP.Bullet && ((AutoRifleHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof ShotGun.Bullet && ((ShotGun)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof ShotGunAP.Bullet && ((ShotGunAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof ShotGunHP.Bullet && ((ShotGunHP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SPAS.Bullet && ((SPAS)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SPASAP.Bullet && ((SPASAP)hero.belongings.weapon).flash)
						|| (hero.belongings.weapon() instanceof SPASHP.Bullet && ((SPASHP)hero.belongings.weapon).flash)) && hero.buff(Light.class) == null
				) {
					Buff.affect(enemy, Blindness.class, 5f);
					Buff.affect(hero, Light.class, 50f);
				}
			}

			if (this instanceof Hero) {
				float heroHPPercent = ((float)hero.HP / (float)hero.HT);
				if (Dungeon.hero.belongings.weapon() instanceof TacticalHandgun.Bullet
						||Dungeon.hero.belongings.weapon() instanceof TacticalHandgunAP.Bullet
						||Dungeon.hero.belongings.weapon() instanceof TacticalHandgunHP.Bullet
						||Dungeon.hero.belongings.weapon() instanceof TacticalShield.Bullet ) {
					dmg *= GameMath.gate(0.125f, 2*heroHPPercent, 1.5f); //0%~6.25% HP : 0.125x, scales defend on Hero health, 75%~100% HP : 1.5x
				}
			}


			if (this instanceof Hero) {
				if (Dungeon.hero.buff(ExtraBullet.class) != null) {
					if (Dungeon.hero.belongings.weapon() instanceof CrudePistol
					 || Dungeon.hero.belongings.weapon() instanceof CrudePistolAP
					 || Dungeon.hero.belongings.weapon() instanceof CrudePistolHP
					 || Dungeon.hero.belongings.weapon() instanceof Pistol
					 || Dungeon.hero.belongings.weapon() instanceof PistolAP
					 || Dungeon.hero.belongings.weapon() instanceof PistolHP
					 || Dungeon.hero.belongings.weapon() instanceof GoldenPistol
					 || Dungeon.hero.belongings.weapon() instanceof GoldenPistolAP
					 || Dungeon.hero.belongings.weapon() instanceof GoldenPistolHP
					 || Dungeon.hero.belongings.weapon() instanceof Handgun
					 || Dungeon.hero.belongings.weapon() instanceof HandgunAP
					 || Dungeon.hero.belongings.weapon() instanceof HandgunHP
					 || Dungeon.hero.belongings.weapon() instanceof Magnum
					 || Dungeon.hero.belongings.weapon() instanceof MagnumAP
					 || Dungeon.hero.belongings.weapon() instanceof MagnumHP
					 || Dungeon.hero.belongings.weapon() instanceof TacticalHandgun
					 || Dungeon.hero.belongings.weapon() instanceof TacticalHandgunAP
					 || Dungeon.hero.belongings.weapon() instanceof TacticalHandgunHP
					 || Dungeon.hero.belongings.weapon() instanceof AutoHandgun
					 || Dungeon.hero.belongings.weapon() instanceof AutoHandgunAP
					 || Dungeon.hero.belongings.weapon() instanceof AutoHandgunHP
					 || Dungeon.hero.belongings.weapon() instanceof DualPistol
					 || Dungeon.hero.belongings.weapon() instanceof DualPistolAP
					 || Dungeon.hero.belongings.weapon() instanceof DualPistolHP
					 || Dungeon.hero.belongings.weapon() instanceof SubMachinegun
					 || Dungeon.hero.belongings.weapon() instanceof SubMachinegunAP
					 || Dungeon.hero.belongings.weapon() instanceof SubMachinegunHP
					 || Dungeon.hero.belongings.weapon() instanceof AssultRifle
					 || Dungeon.hero.belongings.weapon() instanceof AssultRifleAP
					 || Dungeon.hero.belongings.weapon() instanceof AssultRifleHP
					 || Dungeon.hero.belongings.weapon() instanceof HeavyMachinegun
					 || Dungeon.hero.belongings.weapon() instanceof HeavyMachinegunAP
					 || Dungeon.hero.belongings.weapon() instanceof HeavyMachinegunHP
					 || Dungeon.hero.belongings.weapon() instanceof MiniGun
					 || Dungeon.hero.belongings.weapon() instanceof MiniGunAP
					 || Dungeon.hero.belongings.weapon() instanceof MiniGunHP
					 || Dungeon.hero.belongings.weapon() instanceof AutoRifle
					 || Dungeon.hero.belongings.weapon() instanceof AutoRifleAP
					 || Dungeon.hero.belongings.weapon() instanceof AutoRifleHP
					 || Dungeon.hero.belongings.weapon() instanceof HuntingRifle
					 || Dungeon.hero.belongings.weapon() instanceof HuntingRifleAP
					 || Dungeon.hero.belongings.weapon() instanceof HuntingRifleHP
					 || Dungeon.hero.belongings.weapon() instanceof SniperRifle
					 || Dungeon.hero.belongings.weapon() instanceof SniperRifleAP
					 || Dungeon.hero.belongings.weapon() instanceof SniperRifleHP
					 || Dungeon.hero.belongings.weapon() instanceof AntimaterRifle
					 || Dungeon.hero.belongings.weapon() instanceof AntimaterRifleAP
					 || Dungeon.hero.belongings.weapon() instanceof AntimaterRifleHP
					 || Dungeon.hero.belongings.weapon() instanceof MarksmanRifle
					 || Dungeon.hero.belongings.weapon() instanceof MarksmanRifleAP
					 || Dungeon.hero.belongings.weapon() instanceof MarksmanRifleHP
					 || Dungeon.hero.belongings.weapon() instanceof ShotGun
					 || Dungeon.hero.belongings.weapon() instanceof ShotGunAP
					 || Dungeon.hero.belongings.weapon() instanceof ShotGunHP
					 || Dungeon.hero.belongings.weapon() instanceof SPAS
					 || Dungeon.hero.belongings.weapon() instanceof SPASAP
					 || Dungeon.hero.belongings.weapon() instanceof SPASHP
					 || Dungeon.hero.belongings.weapon() instanceof RocketLauncher
					 || Dungeon.hero.belongings.weapon() instanceof RPG7
					 || Dungeon.hero.belongings.weapon() instanceof FlameThrower
					 || Dungeon.hero.belongings.weapon() instanceof FlameThrowerAP
					 || Dungeon.hero.belongings.weapon() instanceof FlameThrowerHP
					 || Dungeon.hero.belongings.weapon() instanceof PlasmaCannon
					 || Dungeon.hero.belongings.weapon() instanceof PlasmaCannonAP
					 || Dungeon.hero.belongings.weapon() instanceof PlasmaCannonHP
					 || Dungeon.hero.belongings.weapon() instanceof GrenadeLauncher
					 || Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherAP
					 || Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherHP
					) {
						dmg += 3;
					}

				}
			}

			if (Dungeon.hero.buff(Riot.riotTracker.class) != null) {
				if (Dungeon.hero.belongings.weapon() instanceof CrudePistol.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof CrudePistolAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof CrudePistolHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof Pistol.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof PistolAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof PistolHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof GoldenPistol.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof GoldenPistolAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof GoldenPistolHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof Handgun.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HandgunAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HandgunHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof Magnum.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MagnumAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MagnumHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof TacticalHandgun.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof TacticalHandgunAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof TacticalHandgunHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AutoHandgun.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AutoHandgunAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AutoHandgunHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof DualPistol.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof DualPistolAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof DualPistolHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SubMachinegun.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SubMachinegunAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SubMachinegunHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AssultRifle.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AssultRifleAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AssultRifleHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HeavyMachinegun.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HeavyMachinegunAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HeavyMachinegunHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MiniGun.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MiniGunAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MiniGunHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AutoRifle.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AutoRifleAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AutoRifleHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HuntingRifle.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HuntingRifleAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof HuntingRifleHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SniperRifle.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SniperRifleAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SniperRifleHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifle.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifleAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifleHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MarksmanRifle.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MarksmanRifleAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof MarksmanRifleHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof ShotGun.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof ShotGunAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof ShotGunHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SPAS.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SPASAP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof SPASHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof RocketLauncher.Rocket
						|| Dungeon.hero.belongings.weapon() instanceof RPG7.Rocket
						//|| Dungeon.hero.belongings.weapon() instanceof FlameThrower.Bullet
						//|| Dungeon.hero.belongings.weapon() instanceof FlameThrowerAP.Bullet
						//|| Dungeon.hero.belongings.weapon() instanceof FlameThrowerHP.Bullet
						//|| Dungeon.hero.belongings.weapon() instanceof PlasmaCannon.Bullet
						//|| Dungeon.hero.belongings.weapon() instanceof PlasmaCannonAP.Bullet
						//|| Dungeon.hero.belongings.weapon() instanceof PlasmaCannonHP.Bullet
						|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncher.Rocket
						|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherAP.Rocket
						|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherHP.Rocket
				) {
					dmg *= 0.5f;
				}

			}

			if (this instanceof Hero) {
				if (hero.heroClass == HeroClass.GUNNER) {
					if (Dungeon.hero.belongings.weapon() instanceof CrudePistol
							|| Dungeon.hero.belongings.weapon() instanceof CrudePistolAP
							|| Dungeon.hero.belongings.weapon() instanceof CrudePistolHP
							|| Dungeon.hero.belongings.weapon() instanceof Pistol
							|| Dungeon.hero.belongings.weapon() instanceof PistolAP
							|| Dungeon.hero.belongings.weapon() instanceof PistolHP
							|| Dungeon.hero.belongings.weapon() instanceof GoldenPistol
							|| Dungeon.hero.belongings.weapon() instanceof GoldenPistolAP
							|| Dungeon.hero.belongings.weapon() instanceof GoldenPistolHP
							|| Dungeon.hero.belongings.weapon() instanceof Handgun
							|| Dungeon.hero.belongings.weapon() instanceof HandgunAP
							|| Dungeon.hero.belongings.weapon() instanceof HandgunHP
							|| Dungeon.hero.belongings.weapon() instanceof Magnum
							|| Dungeon.hero.belongings.weapon() instanceof MagnumAP
							|| Dungeon.hero.belongings.weapon() instanceof MagnumHP
							|| Dungeon.hero.belongings.weapon() instanceof TacticalHandgun
							|| Dungeon.hero.belongings.weapon() instanceof TacticalHandgunAP
							|| Dungeon.hero.belongings.weapon() instanceof TacticalHandgunHP
							|| Dungeon.hero.belongings.weapon() instanceof AutoHandgun
							|| Dungeon.hero.belongings.weapon() instanceof AutoHandgunAP
							|| Dungeon.hero.belongings.weapon() instanceof AutoHandgunHP
							|| Dungeon.hero.belongings.weapon() instanceof DualPistol
							|| Dungeon.hero.belongings.weapon() instanceof DualPistolAP
							|| Dungeon.hero.belongings.weapon() instanceof DualPistolHP
							|| Dungeon.hero.belongings.weapon() instanceof SubMachinegun
							|| Dungeon.hero.belongings.weapon() instanceof SubMachinegunAP
							|| Dungeon.hero.belongings.weapon() instanceof SubMachinegunHP
							|| Dungeon.hero.belongings.weapon() instanceof AssultRifle
							|| Dungeon.hero.belongings.weapon() instanceof AssultRifleAP
							|| Dungeon.hero.belongings.weapon() instanceof AssultRifleHP
							|| Dungeon.hero.belongings.weapon() instanceof HeavyMachinegun
							|| Dungeon.hero.belongings.weapon() instanceof HeavyMachinegunAP
							|| Dungeon.hero.belongings.weapon() instanceof HeavyMachinegunHP
							|| Dungeon.hero.belongings.weapon() instanceof MiniGun
							|| Dungeon.hero.belongings.weapon() instanceof MiniGunAP
							|| Dungeon.hero.belongings.weapon() instanceof MiniGunHP
							|| Dungeon.hero.belongings.weapon() instanceof AutoRifle
							|| Dungeon.hero.belongings.weapon() instanceof AutoRifleAP
							|| Dungeon.hero.belongings.weapon() instanceof AutoRifleHP
							|| Dungeon.hero.belongings.weapon() instanceof HuntingRifle
							|| Dungeon.hero.belongings.weapon() instanceof HuntingRifleAP
							|| Dungeon.hero.belongings.weapon() instanceof HuntingRifleHP
							|| Dungeon.hero.belongings.weapon() instanceof SniperRifle
							|| Dungeon.hero.belongings.weapon() instanceof SniperRifleAP
							|| Dungeon.hero.belongings.weapon() instanceof SniperRifleHP
							|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifle
							|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifleAP
							|| Dungeon.hero.belongings.weapon() instanceof AntimaterRifleHP
							|| Dungeon.hero.belongings.weapon() instanceof MarksmanRifle
							|| Dungeon.hero.belongings.weapon() instanceof MarksmanRifleAP
							|| Dungeon.hero.belongings.weapon() instanceof MarksmanRifleHP
							|| Dungeon.hero.belongings.weapon() instanceof ShotGun
							|| Dungeon.hero.belongings.weapon() instanceof ShotGunAP
							|| Dungeon.hero.belongings.weapon() instanceof ShotGunHP
							|| Dungeon.hero.belongings.weapon() instanceof SPAS
							|| Dungeon.hero.belongings.weapon() instanceof SPASAP
							|| Dungeon.hero.belongings.weapon() instanceof SPASHP
							|| Dungeon.hero.belongings.weapon() instanceof RocketLauncher
							|| Dungeon.hero.belongings.weapon() instanceof RPG7
							|| Dungeon.hero.belongings.weapon() instanceof FlameThrower
							|| Dungeon.hero.belongings.weapon() instanceof FlameThrowerAP
							|| Dungeon.hero.belongings.weapon() instanceof FlameThrowerHP
							|| Dungeon.hero.belongings.weapon() instanceof PlasmaCannon
							|| Dungeon.hero.belongings.weapon() instanceof PlasmaCannonAP
							|| Dungeon.hero.belongings.weapon() instanceof PlasmaCannonHP
							|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncher
							|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherAP
							|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherHP
					) {
						dmg += Random.NormalIntRange(0, hero.belongings.weapon.buffedLvl());
					}
				}
			}

			if (this instanceof Hero) {
				if (Dungeon.hero.hasTalent(Talent.HEAVY_ENHANCE)) {
					if (Dungeon.hero.belongings.weapon() instanceof RocketLauncher.Rocket
							|| Dungeon.hero.belongings.weapon() instanceof RPG7.Rocket
							|| Dungeon.hero.belongings.weapon() instanceof ShotGun.Bullet
							|| Dungeon.hero.belongings.weapon() instanceof ShotGunAP.Bullet
							|| Dungeon.hero.belongings.weapon() instanceof ShotGunHP.Bullet
							|| Dungeon.hero.belongings.weapon() instanceof SPAS.Bullet
							|| Dungeon.hero.belongings.weapon() instanceof SPASAP.Bullet
							|| Dungeon.hero.belongings.weapon() instanceof SPASHP.Bullet
							//|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncher.Rocket see GrenadeLauncher for effect
							//|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherAP.Rocket see GrenadeLauncherAP for effect
							//|| Dungeon.hero.belongings.weapon() instanceof GrenadeLauncherHP.Rocket see GrenadeLauncherHP for effect
					) {
						dmg *= 1f + 0.05f*Dungeon.hero.pointsInTalent(Talent.HEAVY_ENHANCE);
					}
				}
			}

			if (Dungeon.hero.hasTalent(Talent.ONLY_ONE_SHOT)) {
				if (Dungeon.hero.belongings.weapon() instanceof HuntingRifle.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof HuntingRifleAP.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof HuntingRifleHP.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof SniperRifle.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof SniperRifleAP.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof SniperRifleHP.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof AntimaterRifle.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof AntimaterRifleAP.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof AntimaterRifleHP.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof MarksmanRifle.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof MarksmanRifleAP.Bullet
				 || Dungeon.hero.belongings.weapon() instanceof MarksmanRifleHP.Bullet
				) {
					dmg *= 1f + 0.1f*Dungeon.hero.pointsInTalent(Talent.ONLY_ONE_SHOT);
				}
			}

			if ((Dungeon.hero.buff(SpearGuard.class) != null) || (Dungeon.hero.buff(LanceGuard.class) != null)) {
				dmg *= 0.4f;
			}

			if (this instanceof Hero && hero.hasTalent(Talent.TACKLE) && level.adjacent(enemy.pos, hero. pos) && hero.belongings.armor != null && hero.belongings.weapon() instanceof MeleeWeapon) {
				dmg += hero.belongings.armor.DRMax()*0.05f*hero.pointsInTalent(Talent.TACKLE);
			}

			if (this instanceof Hero && hero.belongings.weapon() instanceof MissileWeapon && hero.hasTalent(Talent.VISION_ARROW) && ((Mob) enemy).surprisedBy(hero)) {
				Buff.append(hero, TalismanOfForesight.CharAwareness.class, 3*hero.pointsInTalent(Talent.VISION_ARROW)).charID = enemy.id();
			}

			dmg += dmgBonus;

			//friendly endure
			Endure.EndureTracker endure = buff(Endure.EndureTracker.class);
			if (endure != null) dmg = endure.damageFactor(dmg);

			//enemy endure
			endure = enemy.buff(Endure.EndureTracker.class);
			if (endure != null){
				dmg = endure.adjustDamageTaken(dmg);
			}

			if (enemy.buff(ScrollOfChallenge.ChallengeArena.class) != null){
				dmg *= 0.67f;
			}
			
			int effectiveDamage = enemy.defenseProc( this, dmg );
			effectiveDamage = Math.max( effectiveDamage - dr, 0 );
			
			if ( enemy.buff( Vulnerable.class ) != null){
				effectiveDamage *= 1.33f;
			}
			
			effectiveDamage = attackProc( enemy, effectiveDamage );
			
			if (visibleFight) {
				if (effectiveDamage > 0 || !enemy.blockSound(Random.Float(0.96f, 1.05f))) {
					hitSound(Random.Float(0.87f, 1.15f));
				}
			}

			// If the enemy is already dead, interrupt the attack.
			// This matters as defence procs can sometimes inflict self-damage, such as armor glyphs.
			if (!enemy.isAlive()){
				return true;
			}

			enemy.damage( effectiveDamage, this );

			if (buff(FireImbue.class) != null)  buff(FireImbue.class).proc(enemy);
			if (buff(FrostImbue.class) != null) buff(FrostImbue.class).proc(enemy);

			if (enemy.isAlive() && enemy.alignment != alignment && prep != null && prep.canKO(enemy)){
				enemy.HP = 0;
				if (!enemy.isAlive()) {
					enemy.die(this);
				} else {
					//helps with triggering any on-damage effects that need to activate
					enemy.damage(-1, this);
					DeathMark.processFearTheReaper(enemy);
				}
				enemy.sprite.showStatus(CharSprite.NEGATIVE, Messages.get(Preparation.class, "assassinated"));
				if (Random.Int(5) < hero.pointsInTalent(Talent.ENERGY_DRAW)) {
					CloakOfShadows cloak = hero.belongings.getItem(CloakOfShadows.class);
					if (cloak != null) {
						cloak.overCharge(1);
						ScrollOfRecharging.charge( Dungeon.hero );
						SpellSprite.show( hero, SpellSprite.CHARGE );
					}
				}
			}

			enemy.sprite.bloodBurstA( sprite.center(), effectiveDamage );
			enemy.sprite.flash();

			if (!enemy.isAlive() && visibleFight) {
				if (enemy == Dungeon.hero) {
					
					if (this == Dungeon.hero) {
						return true;
					}

					Dungeon.fail( getClass() );
					GLog.n( Messages.capitalize(Messages.get(Char.class, "kill", name())) );
					
				} else if (this == Dungeon.hero) {
					GLog.i( Messages.capitalize(Messages.get(Char.class, "defeat", enemy.name())) );
				}
			}
			
			return true;
			
		} else {

			if (enemy instanceof Hero) {
				Demonization demonization = hero.buff(Demonization.class);
				if (demonization != null
						&& demonization.isDemonated()
						&& Random.Int(5) == 0
				) {
					Buff.prolong(hero, Flurry.class, Flurry.DURATION);
				}
			}

			if (enemy instanceof Hero && hero.pointsInTalent(Talent.SWIFT_MOVEMENT) == 3) {
				Buff.prolong(hero, Invisibility.class, 1.0001f);
			}

			if (enemy instanceof Hero && hero.hasTalent(Talent.QUICK_PREP)) {
				Momentum momentum = hero.buff(Momentum.class);
				if (momentum != null) {
					momentum.quickPrep(hero.pointsInTalent(Talent.QUICK_PREP));
				}
			}

			enemy.sprite.showStatus( CharSprite.NEUTRAL, enemy.defenseVerb() );
			if (visibleFight) {
				//TODO enemy.defenseSound? currently miss plays for monks/crab even when they parry
				Sample.INSTANCE.play(Assets.Sounds.MISS);
			}
			
			return false;
			
		}
	}

	public static int INFINITE_ACCURACY = 1_000_000;
	public static int INFINITE_EVASION = 1_000_000;

	final public static boolean hit( Char attacker, Char defender, boolean magic ) {
		return hit(attacker, defender, magic ? 2f : 1f);
	}

	public static boolean hit( Char attacker, Char defender, float accMulti ) {
		float acuStat = attacker.attackSkill( defender );
		float defStat = defender.defenseSkill( attacker );

		//if accuracy or evasion are large enough, treat them as infinite.
		//note that infinite evasion beats infinite accuracy
		if (defStat >= INFINITE_EVASION){
			return false;
		} else if (acuStat >= INFINITE_ACCURACY){
			return true;
		}

		float acuRoll = Random.Float( acuStat );
		if (attacker.buff(Bless.class) != null) acuRoll *= 1.25f;
		if (attacker.buff(  Hex.class) != null) acuRoll *= 0.8f;
		for (ChampionEnemy buff : attacker.buffs(ChampionEnemy.class)){
			acuRoll *= buff.evasionAndAccuracyFactor();
		}
		
		float defRoll = Random.Float( defStat );
		if (defender.buff(Bless.class) != null) defRoll *= 1.25f;
		if (defender.buff(  Hex.class) != null) defRoll *= 0.8f;
		for (ChampionEnemy buff : defender.buffs(ChampionEnemy.class)){
			defRoll *= buff.evasionAndAccuracyFactor();
		}
		
		return (acuRoll * accMulti) >= defRoll;
	}
	
	public int attackSkill( Char target ) {
		return 0;
	}
	
	public int defenseSkill( Char enemy ) {
		return 0;
	}
	
	public String defenseVerb() {
		return Messages.get(this, "def_verb");
	}
	
	public int drRoll() {
		return 0;
	}
	
	public int damageRoll() {
		return 1;
	}
	
	//TODO it would be nice to have a pre-armor and post-armor proc.
	// atm attack is always post-armor and defence is already pre-armor
	
	public int attackProc( Char enemy, int damage ) {
		if ( buff(Weakness.class) != null ){
			damage *= 0.67f;
		}
		for (ChampionEnemy buff : buffs(ChampionEnemy.class)){
			damage *= buff.meleeDamageFactor();
			buff.onAttackProc( enemy );
		}
		return damage;
	}
	
	public int defenseProc( Char enemy, int damage ) {
		return damage;
	}
	
	public float speed() {
		float speed = baseSpeed;
		if ( buff( Cripple.class ) != null ) speed /= 2f;
		if ( buff( Stamina.class ) != null) speed *= 1.5f;
		if ( buff( Adrenaline.class ) != null) speed *= 2f;
		if ( buff( Haste.class ) != null) speed *= 3f;
		if ( buff( AngelWing.AngelWingBuff.class ) != null) speed *= 3f;
		if ( buff( Dread.class ) != null) speed *= 2f;
		return speed;
	}
	
	//used so that buffs(Shieldbuff.class) isn't called every time unnecessarily
	private int cachedShield = 0;
	public boolean needsShieldUpdate = true;
	
	public int shielding(){
		if (!needsShieldUpdate){
			return cachedShield;
		}
		
		cachedShield = 0;
		for (ShieldBuff s : buffs(ShieldBuff.class)){
			cachedShield += s.shielding();
		}
		needsShieldUpdate = false;
		return cachedShield;
	}
	
	public void damage( int dmg, Object src ) {
		
		if (!isAlive() || dmg < 0) {
			return;
		}

		if(isInvulnerable(src.getClass())){
			sprite.showStatus(CharSprite.POSITIVE, Messages.get(this, "invulnerable"));
			return;
		}

		for (ChampionEnemy buff : buffs(ChampionEnemy.class)){
			dmg = (int) Math.ceil(dmg * buff.damageTakenFactor());
		}

		if (!(src instanceof LifeLink) && buff(LifeLink.class) != null){
			HashSet<LifeLink> links = buffs(LifeLink.class);
			for (LifeLink link : links.toArray(new LifeLink[0])){
				if (Actor.findById(link.object) == null){
					links.remove(link);
					link.detach();
				}
			}
			dmg = (int)Math.ceil(dmg / (float)(links.size()+1));
			for (LifeLink link : links){
				Char ch = (Char)Actor.findById(link.object);
				ch.damage(dmg, link);
				if (!ch.isAlive()){
					link.detach();
				}
			}
		}

		Terror t = buff(Terror.class);
		if (t != null){
			t.recover();
		}
		Dread d = buff(Dread.class);
		if (d != null){
			d.recover();
		}
		Charm c = buff(Charm.class);
		if (c != null){
			c.recover(src);
		}
		if (this.buff(Frost.class) != null){
			Buff.detach( this, Frost.class );
		}
		if (this.buff(MagicalSleep.class) != null){
			Buff.detach(this, MagicalSleep.class);
		}
		if (this.buff(Doom.class) != null && !isImmune(Doom.class)){
			dmg *= 2;
		}
		if (alignment != Alignment.ALLY && this.buff(DeathMark.DeathMarkTracker.class) != null){
			dmg *= 1.25f;
		}
		
		Class<?> srcClass = src.getClass();
		if (isImmune( srcClass )) {
			dmg = 0;
		} else {
			dmg = Math.round( dmg * resist( srcClass ));
		}
		
		//TODO improve this when I have proper damage source logic
		if (AntiMagic.RESISTS.contains(src.getClass()) && buff(ArcaneArmor.class) != null){
			dmg -= Random.NormalIntRange(0, buff(ArcaneArmor.class).level());
			if (dmg < 0) dmg = 0;
		}
		
		if (buff( Paralysis.class ) != null) {
			buff( Paralysis.class ).processDamage(dmg);
		}

		Endure.EndureTracker endure = buff(Endure.EndureTracker.class);
		if (endure != null){
			dmg = endure.enforceDamagetakenLimit(dmg);
		}

		int shielded = dmg;
		//FIXME: when I add proper damage properties, should add an IGNORES_SHIELDS property to use here.
		if (!(src instanceof Hunger)){
			for (ShieldBuff s : buffs(ShieldBuff.class)){
				dmg = s.absorbDamage(dmg);
				if (dmg == 0) break;
			}
		}
		shielded -= dmg;
		HP -= dmg;
		
		if (sprite != null) {
			sprite.showStatus(HP > HT / 2 ?
							CharSprite.WARNING :
							CharSprite.NEGATIVE,
					Integer.toString(dmg + shielded));
		}

		if (HP < 0) HP = 0;

		if (!isAlive()) {
			die( src );
		} else if (HP == 0 && buff(DeathMark.DeathMarkTracker.class) != null){
			DeathMark.processFearTheReaper(this);
		}
	}
	
	public void destroy() {
		HP = 0;
		Actor.remove( this );

		for (Char ch : Actor.chars().toArray(new Char[0])){
			if (ch.buff(Charm.class) != null && ch.buff(Charm.class).object == id()){
				ch.buff(Charm.class).detach();
			}
			if (ch.buff(Dread.class) != null && ch.buff(Dread.class).object == id()){
				ch.buff(Dread.class).detach();
			}
			if (ch.buff(Terror.class) != null && ch.buff(Terror.class).object == id()){
				ch.buff(Terror.class).detach();
			}
			if (ch.buff(SnipersMark.class) != null && ch.buff(SnipersMark.class).object == id()){
				ch.buff(SnipersMark.class).detach();
			}
		}
	}
	
	public void die( Object src ) {
		destroy();
		if (src != Chasm.class) sprite.die();
	}

	//we cache this info to prevent having to call buff(...) in isAlive.
	//This is relevant because we call isAlive during drawing, which has both performance
	//and thread coordination implications
	public boolean deathMarked = false;
	
	public boolean isAlive() {
		return HP > 0 || deathMarked;
	}
	
	@Override
	protected void spend( float time ) {
		
		float timeScale = 1f;
		if (buff( Slow.class ) != null) {
			timeScale *= 0.5f;
			//slowed and chilled do not stack
		} else if (buff( Chill.class ) != null) {
			timeScale *= buff( Chill.class ).speedFactor();
		}
		if (buff( Speed.class ) != null) {
			timeScale *= 2.0f;
		}
		
		super.spend( time / timeScale );
	}
	
	public synchronized HashSet<Buff> buffs() {
		return new HashSet<>(buffs);
	}
	
	@SuppressWarnings("unchecked")
	//returns all buffs assignable from the given buff class
	public synchronized <T extends Buff> HashSet<T> buffs( Class<T> c ) {
		HashSet<T> filtered = new HashSet<>();
		for (Buff b : buffs) {
			if (c.isInstance( b )) {
				filtered.add( (T)b );
			}
		}
		return filtered;
	}

	@SuppressWarnings("unchecked")
	//returns an instance of the specific buff class, if it exists. Not just assignable
	public synchronized  <T extends Buff> T buff( Class<T> c ) {
		for (Buff b : buffs) {
			if (b.getClass() == c) {
				return (T)b;
			}
		}
		return null;
	}

	public synchronized boolean isCharmedBy( Char ch ) {
		int chID = ch.id();
		for (Buff b : buffs) {
			if (b instanceof Charm && ((Charm)b).object == chID) {
				return true;
			}
		}
		return false;
	}

	public synchronized void add( Buff buff ) {

		if (buff(PotionOfCleansing.Cleanse.class) != null) { //cleansing buff
			if (buff.type == Buff.buffType.NEGATIVE
					&& !(buff instanceof AllyBuff)
					&& !(buff instanceof LostInventory)){
				return;
			}
		}

		buffs.add( buff );
		if (Actor.chars().contains(this)) Actor.add( buff );

		if (sprite != null && buff.announced)
			switch(buff.type){
				case POSITIVE:
					sprite.showStatus(CharSprite.POSITIVE, buff.toString());
					break;
				case NEGATIVE:
					sprite.showStatus(CharSprite.NEGATIVE, buff.toString());
					break;
				case NEUTRAL: default:
					sprite.showStatus(CharSprite.NEUTRAL, buff.toString());
					break;
			}

	}
	
	public synchronized void remove( Buff buff ) {
		
		buffs.remove( buff );
		Actor.remove( buff );

	}
	
	public synchronized void remove( Class<? extends Buff> buffClass ) {
		for (Buff buff : buffs( buffClass )) {
			remove( buff );
		}
	}
	
	@Override
	protected synchronized void onRemove() {
		for (Buff buff : buffs.toArray(new Buff[buffs.size()])) {
			buff.detach();
		}
	}
	
	public synchronized void updateSpriteState() {
		for (Buff buff:buffs) {
			buff.fx( true );
		}
	}
	
	public float stealth() {
		return 0;
	}

	public final void move( int step ) {
		move( step, true );
	}

	//travelling may be false when a character is moving instantaneously, such as via teleportation
	public void move( int step, boolean travelling ) {

		if (travelling && Dungeon.level.adjacent( step, pos ) && buff( Vertigo.class ) != null) {
			sprite.interruptMotion();
			int newPos = pos + PathFinder.NEIGHBOURS8[Random.Int( 8 )];
			if (!(Dungeon.level.passable[newPos] || Dungeon.level.avoid[newPos])
					|| (properties().contains(Property.LARGE) && !Dungeon.level.openSpace[newPos])
					|| Actor.findChar( newPos ) != null)
				return;
			else {
				sprite.move(pos, newPos);
				step = newPos;
			}
		}

		if (Dungeon.level.map[pos] == Terrain.OPEN_DOOR) {
			Door.leave( pos );
		}

		pos = step;
		
		if (this != Dungeon.hero) {
			sprite.visible = Dungeon.level.heroFOV[pos];
		}
		
		Dungeon.level.occupyCell(this );
	}
	
	public int distance( Char other ) {
		return Dungeon.level.distance( pos, other.pos );
	}
	
	public void onMotionComplete() {
		//Does nothing by default
		//The main actor thread already accounts for motion,
		// so calling next() here isn't necessary (see Actor.process)
	}
	
	public void onAttackComplete() {
		next();
	}
	
	public void onOperateComplete() {
		next();
	}
	
	protected final HashSet<Class> resistances = new HashSet<>();
	
	//returns percent effectiveness after resistances
	//TODO currently resistances reduce effectiveness by a static 50%, and do not stack.
	public float resist( Class effect ){
		HashSet<Class> resists = new HashSet<>(resistances);
		for (Property p : properties()){
			resists.addAll(p.resistances());
		}
		for (Buff b : buffs()){
			resists.addAll(b.resistances());
		}
		
		float result = 1f;
		for (Class c : resists){
			if (c.isAssignableFrom(effect)){
				result *= 0.5f;
			}
		}
		return result * RingOfElements.resist(this, effect);
	}
	
	protected final HashSet<Class> immunities = new HashSet<>();
	
	public boolean isImmune(Class effect ){
		HashSet<Class> immunes = new HashSet<>(immunities);
		for (Property p : properties()){
			immunes.addAll(p.immunities());
		}
		for (Buff b : buffs()){
			immunes.addAll(b.immunities());
		}
		
		for (Class c : immunes){
			if (c.isAssignableFrom(effect)){
				return true;
			}
		}
		return false;
	}

	//similar to isImmune, but only factors in damage.
	//Is used in AI decision-making
	public boolean isInvulnerable( Class effect ){
		return false;
	}

	protected HashSet<Property> properties = new HashSet<>();

	public HashSet<Property> properties() {
		HashSet<Property> props = new HashSet<>(properties);
		//TODO any more of these and we should make it a property of the buff, like with resistances/immunities
		if (buff(ChampionEnemy.Giant.class) != null) {
			props.add(Property.LARGE);
		}
		return props;
	}

	public enum Property{
		BOSS ( new HashSet<Class>( Arrays.asList(Grim.class, GrimTrap.class, ScrollOfRetribution.class, ScrollOfPsionicBlast.class)),
				new HashSet<Class>( Arrays.asList(AllyBuff.class, Dread.class) )),
		MINIBOSS ( new HashSet<Class>(),
				new HashSet<Class>( Arrays.asList(AllyBuff.class, Dread.class) )),
		UNDEAD,
		DEMONIC,
		INORGANIC ( new HashSet<Class>(),
				new HashSet<Class>( Arrays.asList(Bleeding.class, ToxicGas.class, Poison.class) )),
		FIERY ( new HashSet<Class>( Arrays.asList(WandOfFireblast.class, Elemental.FireElemental.class)),
				new HashSet<Class>( Arrays.asList(Burning.class, Blazing.class))),
		ICY ( new HashSet<Class>( Arrays.asList(WandOfFrost.class, Elemental.FrostElemental.class)),
				new HashSet<Class>( Arrays.asList(Frost.class, Chill.class))),
		ACIDIC ( new HashSet<Class>( Arrays.asList(Corrosion.class)),
				new HashSet<Class>( Arrays.asList(Ooze.class))),
		ELECTRIC ( new HashSet<Class>( Arrays.asList(WandOfLightning.class, Shocking.class, Potential.class, Electricity.class, ShockingDart.class, Elemental.ShockElemental.class )),
				new HashSet<Class>()),
		LARGE,
		IMMOVABLE;
		
		private HashSet<Class> resistances;
		private HashSet<Class> immunities;
		
		Property(){
			this(new HashSet<Class>(), new HashSet<Class>());
		}
		
		Property( HashSet<Class> resistances, HashSet<Class> immunities){
			this.resistances = resistances;
			this.immunities = immunities;
		}
		
		public HashSet<Class> resistances(){
			return new HashSet<>(resistances);
		}
		
		public HashSet<Class> immunities(){
			return new HashSet<>(immunities);
		}

	}

	public static boolean hasProp( Char ch, Property p){
		return (ch != null && ch.properties().contains(p));
	}
}
