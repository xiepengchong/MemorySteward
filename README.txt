1.�ù��̵����������Ӧ�û��棬
2.Ŀǰֻ����ԣ�Cache��File,��Sd��·���µ��ļ�����������������������ӣ���̳�StewardTool�ļ�
3.ʹ�÷������£�
	1)��ȡStewardToolManagerʵ��StewardToolManager manager = StewardToolManager.getInstance();
	2)ʵ�����������������Sd��Ϊ����SdcardStewardTool sdcardTool = new SdcardStewardTool("edugate");
	3)ע����Ҫ�����·�� manager.registerSteward(sdcardTool);
	4)��������ע���������� manager.clear();
	5)ȫ�����֮�󣬼ǵ�Ҫ��ע��manager.clear();