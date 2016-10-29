package com.bjedrzejewski.tasklistservice;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.google.common.io.CharStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
public class TaskListPost{
}


