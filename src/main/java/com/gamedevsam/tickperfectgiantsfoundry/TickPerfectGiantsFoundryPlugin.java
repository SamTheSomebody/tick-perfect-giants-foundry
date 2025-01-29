package com.gamedevsam.tickperfectgiantsfoundry;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import static com.gamedevsam.tickperfectgiantsfoundry.TickPerfectGiantsFoundryIDs.POLISHING_WHEEL;
import static com.gamedevsam.tickperfectgiantsfoundry.TickPerfectGiantsFoundryIDs.REPUTATION_VARBIT;

@Slf4j
@PluginDescriptor(
	name = "Tick Perfect Giant's Foundry"
)

public class TickPerfectGiantsFoundryPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private TickPerfectGiantsFoundryConfig config;

	@Inject
	private TickPerfectGiantsFoundryOverlay overlay;

	@Inject
	private TickPerfectGiantsFoundryState state;

	@Getter
	private int reputation;

	@Override
	protected void startUp() throws Exception
	{
		overlay.startUp();
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlay.shutDown();
		log.info("Example stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOADING)
		{
			state.setEnabled(false);
		}

		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			reputation = client.getVarpValue(REPUTATION_VARBIT);
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + "Hi", null);
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event) {
		GameObject gameObject = event.getGameObject();
		overlay.setObject(gameObject, true);
		if (gameObject.getId() == POLISHING_WHEEL) {
			//state.setEnabled(true);
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event) {
		GameObject gameObject = event.getGameObject();
		overlay.setObject(gameObject, false);
		if (gameObject.getId() == POLISHING_WHEEL) {
			//state.setEnabled(false);
		}
		client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + gameObject.getId(), null);
	}

	@Provides
	TickPerfectGiantsFoundryConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TickPerfectGiantsFoundryConfig.class);
	}
}
