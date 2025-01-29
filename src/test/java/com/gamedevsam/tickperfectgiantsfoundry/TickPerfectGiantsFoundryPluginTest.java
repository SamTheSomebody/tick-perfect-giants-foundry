package com.gamedevsam.tickperfectgiantsfoundry;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class TickPerfectGiantsFoundryPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(TickPerfectGiantsFoundryPlugin.class);
		RuneLite.main(args);
	}
}