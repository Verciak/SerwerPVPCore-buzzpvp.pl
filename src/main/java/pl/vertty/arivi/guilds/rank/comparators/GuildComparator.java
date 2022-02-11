
package pl.vertty.arivi.guilds.rank.comparators;

import pl.vertty.arivi.guilds.data.guild.Guild;

import java.util.Comparator;

public class GuildComparator implements Comparator<Guild>
{
    public int comparee(final Object o, final Object o2) {
        return this.compare((Guild)o, (Guild)o2);
    }
    
    @Override
    public int compare(final Guild guild, final Guild guild2) {
        return Integer.valueOf(guild2.getPoints()).compareTo(guild.getPoints());
    }
}
