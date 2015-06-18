1.该工程的作用是清除应用缓存，
2.目前只是针对：Cache，File,与Sd卡路径下的文件进行清理，如有特殊需求添加，请继承StewardTool文件
3.使用方法如下：
	1)获取StewardToolManager实例StewardToolManager manager = StewardToolManager.getInstance();
	2)实例化各个清理对象，以Sd卡为例：SdcardStewardTool sdcardTool = new SdcardStewardTool("edugate");
	3)注册需要清理的路径 manager.registerSteward(sdcardTool);
	4)清理所有注册的清理对象 manager.clear();
	5)全部完成之后，记得要解注册manager.clear();