package br.com.ocpoint.service;

import org.springframework.stereotype.Service;

import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public AccessGroup getGroupById(Integer id) {
        return groupRepository.getGroupById(id);
    }

}
