import java.time.LocalDate;

/**
 * @Author: Rudolf Sirbu
 * Class representing an artifact in the museum
 */
public class Artifact
{

    private String id;
    private String name;
    private String description;
    private int yearAcquired;

    /**
     * Adds a new artifact to the specified exhibit.
     * @param id The unique ID of the artifact.
     * @param name The name of the artifact.
     * @param description A brief description of the artifact.
     * @param yearAcquired The year the artifact was acquired.
     */
    public Artifact(String id, String name, String description, int yearAcquired)
    {
        // Validating input within the constructor ensures no invalid objects can ever exist
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (yearAcquired > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year acquired cannot be in the future");
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.yearAcquired = yearAcquired;
    }

    // Getters and setters
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getYearAcquired()
    {
        return yearAcquired;
    }

    public void setYearAcquired(int yearAcquired)
    {
        this.yearAcquired = yearAcquired;
    }


    @Override
    public String toString()
    {
        return String.format("ID: %s, Name: %s, Description: %s, Year Acquired: %d",
                id, name, description, yearAcquired);
    }
}
