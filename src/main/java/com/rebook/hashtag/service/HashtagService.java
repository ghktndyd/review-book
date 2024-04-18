package com.rebook.hashtag.service;

import com.rebook.hashtag.domain.HashtagEntity;
import com.rebook.hashtag.dto.requeest.HashtagRequest;
import com.rebook.hashtag.dto.response.HashtagResponse;
import com.rebook.hashtag.exception.HashtagNotFoundException;
import com.rebook.hashtag.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    @Transactional
    public HashtagResponse create(final HashtagRequest hashtagCreateRequest) {
        HashtagEntity hashtag = HashtagEntity.of(
                hashtagCreateRequest.getName()
        );
        HashtagEntity createdHashtag = hashtagRepository.save(hashtag);

        return HashtagResponse.of(createdHashtag);
    }

    @Transactional(readOnly = true)
    public List<HashtagResponse> getHashtags() {
        List<HashtagEntity> hashtags = hashtagRepository.findAll();

        return hashtags.stream()
                .map(HashtagResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public HashtagResponse getHashtag(final Long hashtagId) {
        HashtagEntity hashtag = hashtagRepository.findById(hashtagId)
                .orElseThrow(HashtagNotFoundException::new);

        return HashtagResponse.of(hashtag);
    }

    @Transactional
    public void update(final Long hashtagId, final HashtagRequest hashtagUpdateRequest) {
        HashtagEntity hashtagEntity = hashtagRepository.findById(hashtagId)
                .orElseThrow(HashtagNotFoundException::new);

        hashtagEntity.changeName(hashtagUpdateRequest);
    }

}

