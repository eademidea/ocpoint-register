package br.com.ocpoint.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ocpoint.model.AccessGroup;
import br.com.ocpoint.repository.GroupRepository;

@RunWith(SpringRunner.class)
public class GroupServiceImplTest {

    @Mock
    private GroupRepository groupRepository;

    private GroupServiceImpl serviceImpl;

    @Before
    public void init() {
        this.serviceImpl = new GroupServiceImpl(groupRepository);
    }

    @Test
    public void getGroupByIdIsNull() {
        Mockito.when(
                this.groupRepository.getGroupById(Mockito.any())).thenReturn(null);
        Assert.assertNull(serviceImpl.getGroupById(2));
    }

    @Test
    public void getGroupByIdTestIsntNull() {
        Mockito.when(
                this.groupRepository.getGroupById(Mockito.any())).thenReturn(new AccessGroup());
        Assert.assertNotNull(serviceImpl.getGroupById(2));
    }

}
