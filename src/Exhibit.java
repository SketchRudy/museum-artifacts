/**
 * @Author: Rudy S
 * Class representing an exhibit in the museum
 */

import java.util.HashSet;
import java.util.Set;


public class Exhibit
{
    private String name;
    private Set<Artifact> artifacts;

    // Constructor

    public Exhibit(String name)
    {
        this.name = name;
        this.artifacts = new HashSet<>();
    }

    // Getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Artifact> getArtifacts()
    {
        return artifacts;
    }

    // Methods to add and remove artifacts
    public void addArtifact(Artifact artifact)
    {
        artifacts.add(artifact);
    }

    public void removeArtifact(String artifactId)
    {
        artifacts.removeIf(artifact -> artifact.getId().equals(artifactId));
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Exhibit: ").append(name).append("\nArtifacts:\n");
        int count = 1;
        for (Artifact artifact : artifacts) {
            sb.append(count++).append(". ").append(artifact).append("\n");
        }
        return sb.toString();
    }
}
