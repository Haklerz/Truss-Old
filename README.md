Truss

Texture
Represents a image that can be drawn on.
Textures can be drawn on textures.

Window
Contains a double buffered texture that can be drawn on.
Flip method swaps the buffers.

```java
import com.haklerz.truss.Truss;

public static void main(String[] args) {
    Truss.start(new Game());
}
```