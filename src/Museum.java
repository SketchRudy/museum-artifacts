/**
 * @Author: Rudolf Sirbu
 * Class representing the museum with its collection of exhibits
 */
import java.util.HashMap;
import java.util.Map;

public class Museum
{
    private Map<String, Exhibit> exhibits;

    // Constructor
    public Museum()
    {
        this.exhibits = new HashMap<>();
    }

    // Methods to add, remove, and retrieve exhibits
    public void addExhibit(String name)
    {
        exhibits.put(name, new Exhibit(name));
    }

    public void removeExhibit(String name)
    {
        exhibits.remove(name);
    }

    public Exhibit getExhibit(String name)
    {
        return exhibits.get(name);
    }

    public void transferArtifact(String artifactId, String fromExhibit, String toExhibit)
    {
        Exhibit source = exhibits.get(fromExhibit);
        Exhibit destination = exhibits.get(toExhibit);

        if (source != null && destination != null)
        {
            Artifact artifactToTransfer = null;
            for (Artifact artifact : source.getArtifacts())
            {
                if (artifact.getId().equals(artifactId))
                {
                    artifactToTransfer = artifact;
                    break;
                }
            }
            if (artifactToTransfer != null)
            {
                source.removeArtifact(artifactId);
                destination.addArtifact(artifactToTransfer);
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Exhibits in the museum:\n");
        for (String exhibitName : exhibits.keySet())
        {
            sb.append(exhibitName).append("\n");
        }
        return sb.toString();
    }
}
