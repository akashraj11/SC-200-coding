package com.stackroute.neo4jservice.service.nodeservice;

import com.stackroute.neo4jservice.domain.nodes.Source;
import com.stackroute.neo4jservice.domain.nodes.User;

import java.util.List;

public interface SourceService {
    public Source saveSource(Source source);
    public String deleteSource(String id);
   public List<Source> getSource();
}
