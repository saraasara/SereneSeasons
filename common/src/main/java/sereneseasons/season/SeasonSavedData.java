/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package sereneseasons.season;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.level.saveddata.SavedData;

public class SeasonSavedData extends SavedData
{
    public static final String DATA_IDENTIFIER = "seasons";
    public static final int VERSION = 0;
    
    public int seasonCycleTicks;

    @Override
    public CompoundTag save(CompoundTag nbt, HolderLookup.Provider provider)
    {
        nbt.putInt("SeasonCycleTicks", this.seasonCycleTicks);
        return nbt;
    }

    public static SeasonSavedData load(CompoundTag nbt, HolderLookup.Provider provider)
    {
        SeasonSavedData data = new SeasonSavedData();
        data.seasonCycleTicks = Mth.clamp(nbt.getInt("SeasonCycleTicks"), 0, SeasonTime.ZERO.getCycleDuration());
        return data;
    }


}
