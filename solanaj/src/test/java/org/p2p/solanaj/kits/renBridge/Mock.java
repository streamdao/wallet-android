package org.p2p.solanaj.kits.renBridge;

import org.p2p.solanaj.core.PublicKey;
import org.p2p.solanaj.kits.renBridge.renVM.RenVMProvider;
import org.p2p.solanaj.model.types.AccountInfo;
import org.p2p.solanaj.rpc.Environment;
import org.p2p.solanaj.rpc.RpcApi;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.rpc.RpcException;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class Mock {
    public static final String base64GatewayRegistryData = "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";

    public static RpcClient buildSolanaRpcClient() {
        return new RpcClient(Environment.DEVNET) {

            @Override
            public RpcApi getApi() {
                return new RpcApi(this) {

                    @Override
                    public AccountInfo getAccountInfo(PublicKey account) {
                        return new AccountInfo() {

                            @Override
                            public Value getValue() {
                                return new Value() {

                                    @Override
                                    public List<String> getData() {
                                        return Arrays.asList(base64GatewayRegistryData);
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static RenVMProvider buildRenVMProvider() {
        return new RenVMProvider(NetworkConfig.DEVNET()) {

            @Override
            public byte[] selectPublicKey() throws RpcException {
                return Base64.getDecoder().decode("Aw3WX32ykguyKZEuP0IT3RUOX5csm3PpvnFNhEVhrDVc");
            }
        };
    }

}
