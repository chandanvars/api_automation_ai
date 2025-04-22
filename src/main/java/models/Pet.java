package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "category",
        "name",
        "tags",
        "status"
})
public class Pet {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tags")
    private List<Tag> tags;

    @JsonProperty("status")
    private String status;

    // Getters and Setters
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    // Nested Category class
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "name"
    })
    public static class Category {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;

        public Category() {
        }

        public Category(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @JsonProperty("id")
        public Long getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Long id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Category)) return false;
            Category category = (Category) o;
            return Objects.equals(id, category.id) &&
                    Objects.equals(name, category.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    // Nested Tag class
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "name"
    })
    public static class Tag {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;

        public Tag() {
        }

        public Tag(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @JsonProperty("id")
        public Long getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Long id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tag)) return false;
            Tag tag = (Tag) o;
            return Objects.equals(id, tag.id) &&
                    Objects.equals(name, tag.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Tag{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}