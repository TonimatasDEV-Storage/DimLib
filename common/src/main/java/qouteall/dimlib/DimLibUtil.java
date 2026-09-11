package qouteall.dimlib;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.lang.reflect.Type;

public class DimLibUtil {
    
    public static final Gson GSON;
    
    public static long secondToNano(double second) {
        return (long) (second * 1000000000);
    }
    
    public static double nanoToSecond(long l) {
        return l / 1000000000.0;
    }
    
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        
        gsonBuilder.registerTypeAdapter(
            new TypeToken<ResourceKey<Level>>() {}.getType(),
            new DimensionIDJsonAdapter()
        );
        
        GSON = gsonBuilder.create();
    }
    
    private static class DimensionIDJsonAdapter
        implements JsonSerializer<ResourceKey<Level>>, JsonDeserializer<ResourceKey<Level>> {
        
        @Override
        public ResourceKey<Level> deserialize(
            JsonElement json, Type typeOfT, JsonDeserializationContext context
        ) throws JsonParseException {
            String str = json.getAsString();
            return ResourceKey.create(
                Registries.DIMENSION, Identifier.parse(str)
            );
        }
        
        @Override
        public JsonElement serialize(ResourceKey<Level> src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.identifier().toString());
        }
    }
}
