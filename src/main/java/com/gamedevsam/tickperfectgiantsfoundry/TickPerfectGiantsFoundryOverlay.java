package com.gamedevsam.tickperfectgiantsfoundry;

import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

public class TickPerfectGiantsFoundryOverlay {

    @Inject
    private OverlayManager overlayManager;

    private static final int TRIP_HAMMER = 44619;
    private static final int GRINDSTONE = 44620;
    private static final int POLISHING_WHEEL = 44621;

    private static final int LAVA_POOL = 44631;
    private static final int WATERFALL = 44632;

    private static final int CRUCIBLE = 44776;
    private static final int MOULD_JIG = 44777;
    private static final int STORAGE = 44778;

    GameObject tripHammer;
    GameObject grindstone;
    GameObject polishingWheel;
    GameObject lavaPool;
    GameObject waterfall;
    GameObject mouldJig;
    GameObject crucible;
    GameObject storage;
    NPC kovac;

    public void startUp()
    {
        //overlayManager.add(overlay2d);
        //overlayManager.add(overlay3d);
    }

    public void shutDown()
    {
        //overlayManager.remove(overlay2d);
        //overlayManager.remove(overlay3d);
    }

    public void setObject(GameObject gameObject, boolean active)
    {
        final int id = gameObject.getId();
        if (!active) {
            gameObject = null;
        }
        
        switch (id)
        {
            case POLISHING_WHEEL:
                polishingWheel = gameObject;
                break;
            case GRINDSTONE:
                grindstone = gameObject;
                break;
            case LAVA_POOL:
                lavaPool = gameObject;
                break;
            case WATERFALL:
                waterfall = gameObject;
                break;
            case TRIP_HAMMER:
                tripHammer = gameObject;
                break;
            case MOULD_JIG:
                mouldJig = gameObject;
                break;
            case CRUCIBLE:
                crucible = gameObject;
                break;
            case STORAGE:
                storage = gameObject;
                break;
        }
    }

}
