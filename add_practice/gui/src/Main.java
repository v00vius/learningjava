import imgui.ImGui;
import imgui.ImVec4;
import imgui.app.Application;
import imgui.app.Configuration;
import imgui.type.ImBoolean;

public class Main extends Application {
    private ImBoolean showDemo = new ImBoolean(true);
    private boolean myToolActive = true;

    @Override
    protected void configure(Configuration config) {
        config.setTitle("Dear ImGui is Awesome!");
    }

    @Override
    public void process() {
        // ImGui.text("Hello, World!");
        // Create a window called "My First Tool", with a menu bar.
        ImGui.begin("My First Tool", showDemo);

        if (ImGui.beginMainMenuBar())
        {
            if (ImGui.beginMenu("File"))
            {
                if (ImGui.menuItem("Open..", "Ctrl+O")) { /* Do stuff */ }
                if (ImGui.menuItem("Save", "Ctrl+S"))   { /* Do stuff */ }
                if (ImGui.menuItem("Close", "Ctrl+W"))  { myToolActive = false; }

                ImGui.endMenu();
            }

            ImGui.endMainMenuBar();
        }

        // Edit a color stored as 4 floats
        // ImGui.colorEdit4("Color", my_color);

        // Generate samples and plot them
        float[] samples = new float[100];
        
        for (int n = 0; n < 100; n++)
            samples[n] = (float) Math.sin(n * 2.0f + ImGui.getTime() * 2.0f);

        ImGui.plotLines("Samples", samples, 100);

        // Display contents in a scrolling region
        // ImGui.textColored(0, "Important Stuff"); // new ImVec4(1,1,0,1);
        ImGui.beginChild("Scrolling");

            for (int n = 0; n < 50; n++)
                ImGui.text(n + " Some text");

        ImGui.endChild();
        ImGui.end();        
    }

    public static void main(String[] args) {
        launch(new Main());
    }
}
