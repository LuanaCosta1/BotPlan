package com.botplan.backend.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SprintStoriesDTO extends SprintDTO {
    private List<StoryDTO> stories;
}
