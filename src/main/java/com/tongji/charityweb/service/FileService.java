package com.tongji.charityweb.service;

import com.tongji.charityweb.model.project.Project;
import com.tongji.charityweb.model.repository.Repository;
import com.tongji.charityweb.model.user.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class FileService
{
	private static String separator = File.separator;
	private static String uploadedFilesDirectory = "uploadedFiles" + separator;
	private static String parentUploadDirectory = "src"+separator+"main"+separator+"resources"+separator+"static"+separator;
	private static String userFileName = "userHeadPortrait";
	private static String projectFileName = "projectDescriptionPicture";
	private static String repositoryFileName = "repositoryDescriptionPicture";


	public String storeNewFile(MultipartFile file,String path,String fileName)
	{
		if (!file.isEmpty()) {

			String originFileName = file.getOriginalFilename();
			//做了路径的拼接和文件名的拼接
			File newFile = new File(parentUploadDirectory + uploadedFilesDirectory + path,fileName+originFileName.substring(originFileName.lastIndexOf(".")));
			//File newFile = new File(parentUploadDirectory + uploadedFilesDirectory + path,originFileName);
			if(!newFile.exists())
			{
				if(!newFile.getParentFile().mkdirs())
				{
					String error = "创建目录失败或已存在该目录";
					System.out.println(error);
				}
			}
			try {
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(newFile));
				out.write(file.getBytes());
				out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "upload failed," + e.getMessage();
			} catch (IOException e) {
				e.printStackTrace();
				return "upload failed," + e.getMessage();
			}
			//System.out.println("文件名："+newFile.getParent()+separator+newFile.getName());
			//上传成功，返回文件的url
			return uploadedFilesDirectory + path + separator+newFile.getName();
		}
		else {
			return "upload failed,because the file is empty file";
		}
	}

	public String uploadUserPicture(MultipartFile file, User user)
	{
		String path = user.getUsername();
		return  storeNewFile(file, path, userFileName);
	}

	public String uploadRepositoryPicture(MultipartFile file, Repository repository)
	{
		String path = repository.getUsername() + separator + repository.getRepositoryName();
		return  storeNewFile(file, path, repositoryFileName);
	}

	public String uploadProjectPicture(MultipartFile file, Project project)
	{
		String path = project.getUserName() + separator + project.getRepName() + separator + project.getProjectName();
		return  storeNewFile(file, path, projectFileName);
	}



}
