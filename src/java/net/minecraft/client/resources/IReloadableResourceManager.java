package net.minecraft.client.resources;

import java.util.List;

public interface IReloadableResourceManager extends IResourceManager
{
    void reloadResources(List<IResourcePack> resourcesPacksList, boolean language);

    void registerReloadListener(IResourceManagerReloadListener reloadListener);
}
