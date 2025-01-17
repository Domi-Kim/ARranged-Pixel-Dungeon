/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
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

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfDisintegration;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class SpellBook_Disintegration extends MeleeWeapon {

	{
		image = ItemSpriteSheet.DISTRIBUTION_SPELLBOOK;
		hitSound = Assets.Sounds.HIT;
		hitSoundPitch = 1.1f;

		tier = 3;
		RCH = 2;
		alchemy = true;
	}

	@Override
	public int reachFactor(Char owner) {
		int reach = super.reachFactor(owner);
		reach += Math.min(buffedLvl(), 10); //increases reach per lvl, up to +10 tiles
		return reach;
	}

	@Override
	public int max(int lvl) {
		return Math.round(2.5f * (tier + 1)) +     //10 base, down from 20
				lvl * (tier - 1);                   //+2 per level, down from +4
	}

	public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{SpellBook_Empty.class, WandOfDisintegration.class};
			inQuantity = new int[]{1, 1};

			cost = 10;

			output = SpellBook_Disintegration.class;
			outQuantity = 1;
		}
	}
}
